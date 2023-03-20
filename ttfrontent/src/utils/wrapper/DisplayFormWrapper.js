import { Form, Button, Header, Icon } from 'semantic-ui-react';
import './Index.scss';

export const DisplayFormWrapper = props => {

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
                        <div className='jj'>
                            <div style={{ display: 'inline-block' }}>
                                <Form.Button type='button' animated inverted color='brown' onClick={handleButtonAction}>
                                    <Button.Content visible>{buttonName}</Button.Content>
                                    <Button.Content hidden>
                                        <Icon name={buttonIcon} />
                                    </Button.Content>
                                </Form.Button>
                            </div>

                            <SubmitButtom submitButtonName={submitButtonName} submitButtonIcon={submitButtonIcon} />
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