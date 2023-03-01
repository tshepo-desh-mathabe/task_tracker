import { Form, Button, Segment, Header, Icon } from 'semantic-ui-react';
import './Index.scss';

export const DisplayFormWrapper = props => {

    const { headerIcon, headerName, formData, children, buttonIcon, buttonName } = props;

    return (
        <Segment>
            <div className='display-form-header-icon'>
                <Header icon>
                    <Icon name={headerIcon} />
                    {headerName}
                </Header>
            </div>
            <Form onSubmit={formData}>
                {children}
                <div className='submit-button'>
                    <Form.Button inverted color='brown' animated>
                        <Button.Content visible>{buttonName}</Button.Content>
                        <Button.Content hidden>
                            <Icon name={buttonIcon} />
                        </Button.Content>
                    </Form.Button>
                </div>
            </Form>
        </Segment>
    );
}