import React, { Component } from 'react';
import { Container } from 'semantic-ui-react';
import { dataChecker, emailRegex } from '../../utils/Validator';
import { LoginForm } from './LogInForm';
import AppMessage from '../../utils/message/AppMessage';
import PageLoader from '../../utils/PageLoader/PageLoader';
import { DisplayWrapper, DisplayFormWrapper } from '../../utils/wrapper/index';
import FORM_CONST from '../../utils/constants/form_constants.json';
import APP_CONST from '../../utils/constants/app_contants.json';

const error = FORM_CONST.error;

const initialState = {
    showLoader: { flag: false, content: '' },
    showMessage: {
        flag: false,
        icon: '',
        topic: '',
        content: ''
    },
    sendingFlag: false,
    emailAddress: '',
    password: '',
};

export class Login extends Component {
    constructor(props) {
        super(props);

        this.state = initialState;

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleModalClick = this.handleModalClick.bind(this);
    }

    handleChange = (e, { name, value }) => {
        if (this.state.sendingFlag) {
            this.setState({ [name]: value, sendingFlag: false });
        } else {
            this.setState({ [name]: value });
        }
    }

    handleModalClick() {
        this.setState({ showMessage: { flag: false, content: '' } });
    }

    fieldChecker() {
        const state = this.state;
        const checker = dataChecker(state.emailAddress) && dataChecker(state.password);
        return checker;
    }

    handleSubmit() {
        const state = this.state;

        if (!this.fieldChecker()) {
            this.setState({
                sendingFlag: true,
                showMessage: {
                    flag: true, icon: 'edit',
                    topic: error.emptyFields, content: error.fillEmptyFields
                }
            });
        } else if (!emailRegex(state.emailAddress)) {
            this.setState({
                sendingFlag: true,
                showMessage: {
                    flag: true, icon: 'mail',
                    topic: error.badEmail,
                    content: error.emailAddress
                }
            });
        } else {
            this.httpCall(state);
        }
    }

    httpCall(state) { }

    DisplayElement = () => {
        const state = this.state;

        if (state.showMessage.flag) {
            return <AppMessage
                iconName={state.showMessage.icon}
                isOpen={state.showMessage.flag}
                headingInfo={state.showMessage.topic}
                message={state.showMessage.content}
                handleModalClick={this.handleModalClick}
            />;
        } else if (state.showLoader.flag) {
            return <PageLoader loaderInfo={state.showLoader.content} />;
        } else {
            return (
                <DisplayWrapper body={
                    <RenderForm sendingFlag={state.sendingFlag} emailAddress={state.emailAddress}
                        password={state.password} handleChange={this.handleChange} handleSubmit={this.handleSubmit} />
                } />
            );
        }
    }

    render() {
        return <this.DisplayElement />;
    }
}

const RenderForm = props => {
    const { sendingFlag, emailAddress, password, handleChange, handleSubmit } = props
    return (
        <Container>
            <DisplayFormWrapper headerIcon='sign-in' headerName={APP_CONST.signin}
                formData={handleSubmit} buttonIcon='sign-in' buttonName={APP_CONST.signin}
                children={
                    <LoginForm sendingFlag={sendingFlag} emailAddress={emailAddress}
                        password={password} handleChange={handleChange} />
                }
            />
        </Container>
    );
}
