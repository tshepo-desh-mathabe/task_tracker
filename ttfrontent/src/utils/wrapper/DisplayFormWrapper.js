import React from 'react';
import { Form, Button, Header, Icon } from 'semantic-ui-react';
import Message from '../message/Message';
import PageLoader from '../page_loader/PageLoader';
import appStore from '../store/AppStore';
import './Index.scss';


export const DisplayFormWrapper = props => {
    const { headerIcon, headerName, formData, children, submitButtonIcon, buttonIcon, submitButtonName, buttonName, handleButtonAction,
        messageFlag, loadingFlag, allowSecondButton, handleModalClick } = props;

    const loader = appStore.getLoader();
    const message = appStore.getMessage();

    if (messageFlag) {
        return <Message
            iconName={message.messageIcon}
            isOpen={message.messageFlag}
            headingInfo={message.messageTopic}
            message={message.messageContent}
            handleModalClick={handleModalClick}
        />;
    } else if (loadingFlag) {
        return <PageLoader loaderInfo={loader.content} />;
    } else {
        return (
            <PreFormWrapper headerIcon={headerIcon} headerName={headerName} formData={formData} children={children} submitButtonIcon={submitButtonIcon}
                buttonIcon={buttonIcon} submitButtonName={submitButtonName} buttonName={buttonName} handleButtonAction={handleButtonAction} allowSecondButton={allowSecondButton}
            />
        );
    }
}

const PreFormWrapper = props => {

    const { headerIcon, headerName, formData, children, submitButtonIcon, buttonIcon,
        submitButtonName, buttonName, handleButtonAction, allowSecondButton } = props;

    return (
        <>
            <div className='display-form-header-icon'>
                <Header icon>
                    <Icon name={headerIcon} />
                    {headerName}
                </Header>
            </div>
            <hr />
            <Form onSubmit={formData}>
                {children}
                <hr />
                {
                    !allowSecondButton ?
                        <SubmitButtom submitButtonName={submitButtonName} submitButtonIcon={submitButtonIcon} />
                        :
                        <div>
                            <SubmitButtom submitButtonName={submitButtonName} submitButtonIcon={submitButtonIcon} />
                            <div style={{ display: 'inline-block' }}>
                                <Form.Button type='button' animated inverted color='brown' onClick={handleButtonAction}>
                                    <Button.Content visible>{buttonName}</Button.Content>
                                    <Button.Content hidden>
                                        <Icon name={buttonIcon} />
                                    </Button.Content>
                                </Form.Button>
                            </div>
                        </div>
                }
            </Form>
        </>
    );
}

const SubmitButtom = props => {
    const { submitButtonName, submitButtonIcon } = props;

    return (
        <div style={{ display: 'inline-block' }}>
            <Form.Button type='submit' animated inverted color='brown'>
                <Button.Content visible>{submitButtonName}</Button.Content>
                <Button.Content hidden>
                    <Icon name={submitButtonIcon} />
                </Button.Content>
            </Form.Button>
        </div>
    )
}