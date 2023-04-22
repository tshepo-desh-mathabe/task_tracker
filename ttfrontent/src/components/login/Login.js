import React, { Component } from 'react';
import { Container } from 'semantic-ui-react';
import { dataChecker, emailRegex } from '../../utils/Validator';
import { LoginForm } from './LogInForm';
import { DisplayFormWrapper } from '../../utils/wrapper/index';
import FORM_CONST from '../../utils/constants/form_constants.json';
import APP_CONST from '../../utils/constants/app_contants.json';
import { signIn } from '../../utils/api/UserService';
import appStore from '../../utils/store/AppStore';

const error = FORM_CONST.error;

const initialState = {
    sendingFlag: false,
    emailAddress: '',
    password: '',
    globalStore: appStore.getAll()
};

export class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            sendingFlag: false,
            emailAddress: '',
            password: '',
            globalStore: appStore.getAll()
        };

        this.onChange = this.onChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleModalClick = this.handleModalClick.bind(this);
    }

    onChange() {
        this.setState({ globalStore: appStore.getAll() });
    }

    componentDidMount() {
        appStore.addChangeListener(this.onChange);
    }

    componentWillUnmount() {
        appStore.removeChangeListener(this.onChange);
    }

    handleChange = (e, { name, value }) => {
        e.preventDefault();
        this.state.sendingFlag ? this.setState({ [name]: value, sendingFlag: false }) :
            this.setState({ [name]: value });
    }

    handleModalClick(e) {
        appStore.setMessage({ flag: false });
        // this.onChange();
    }

    fieldChecker() {
        const state = this.state;
        const checker = dataChecker(state.emailAddress) && dataChecker(state.password);
        return checker;
    }

    handleSubmit() {
        const state = this.state;

        if (!this.fieldChecker()) {
            this.setState({ sendingFlag: true });
            appStore.setMessage({
                flag: true, icon: 'edit',
                topic: error.emptyFields, content: error.fillEmptyFields
            });
        } else if (!emailRegex(state.emailAddress)) {
            this.setState({ sendingFlag: true });
            appStore.setMessage({
                flag: true, icon: 'mail',
                topic: error.badEmail,
                content: error.emailAddress
            });
        } else {
            this.httpCall(state);
        }
    }

    httpCall(state) {
        this.setState({ sendingFlag: true });
        appStore.setLoader({ flag: true, content: APP_CONST.pleaseWaitWhileCompletion });

        const dataToBeSent = {
            email: state.emailAddress,
            password: state.password
        }

        signIn(dataToBeSent).then(res => {
            const resData = res.data;
            if (!resData.success) {
                appStore.setLoader({ flag: false, content: '' });
                appStore.setMessage({
                    flag: true, icon: 'exclamation triangle',
                    topic: APP_CONST.oopsie, content: resData.message
                });
            } else {
                appStore.setUserDetails(res.data.message);
                this.setState(initialState);
            }
        }).catch(err => {
            let messageText = APP_CONST.defaultError;
            const responseData = err.response;

            if (responseData !== undefined && responseData.status === 400 && responseData.data !== undefined) {
                messageText = responseData.data.message;
            }

            appStore.setLoader({ flag: false, content: '' });
            appStore.setMessage({
                flag: true, icon: 'exclamation triangle',
                topic: APP_CONST.oopsie, content: messageText
            });
        });
    }

    render() {
        const { sendingFlag, emailAddress, password, globalStore } = this.state;
        return (
            <div className='auth'>
                <RenderForm sendingFlag={sendingFlag} emailAddress={emailAddress} password={password} messageFlag={globalStore.isMessaging.messageFlag} loadingFlag={globalStore.isLoading.flag}
                    handleChange={this.handleChange} handleSubmit={this.handleSubmit} handleModalClick={this.handleModalClick} />
            </div>
        );
    }
}

const RenderForm = props => {
    const { sendingFlag, emailAddress, password, handleChange, messageFlag, loadingFlag, handleModalClick, handleSubmit } = props
    return (
        <Container>
            <DisplayFormWrapper headerIcon='sign-in' headerName={APP_CONST.signin}
                submitButtonIcon='sign-in' messageFlag={messageFlag} loadingFlag={loadingFlag}
                formData={handleSubmit} submitButtonName={APP_CONST.signin} handleModalClick={handleModalClick}
                children={
                    <LoginForm sendingFlag={sendingFlag} emailAddress={emailAddress}
                        password={password} handleChange={handleChange} />
                }
            />
        </Container>
    );
}