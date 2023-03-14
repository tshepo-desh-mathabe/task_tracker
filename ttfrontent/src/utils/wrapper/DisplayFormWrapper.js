import { Form, Button, Header, Icon } from 'semantic-ui-react';
import './Index.scss';

export const DisplayFormWrapper = props => {

    const { headerIcon, headerName, formData, children, buttonIcon, buttonName } = props;

    return (
        <>
            <div className='display-form-header-icon'>
                <Header icon>
                    <Icon name={headerIcon} />
                    {headerName}
                </Header>
            </div>
            <Form onSubmit={formData}>
                {children}
                <hr/>
                <div className='submit-button'>
                    <Form.Button animated inverted color='brown'>
                        <Button.Content visible>{buttonName}</Button.Content>
                        <Button.Content hidden>
                            <Icon name={buttonIcon} />
                        </Button.Content>
                    </Form.Button>
                </div>
            </Form>
        </>
    );
}