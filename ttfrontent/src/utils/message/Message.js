import React from 'react';
import { Button, Header, Icon, Modal } from 'semantic-ui-react';
import './Message.scss';

const AppMessage = props => {
  const { iconName, headingInfo, message, isOpen, handleModalClick } = props;

  return (
    <MessageModel iconName={iconName} headingInfo={headingInfo}
      message={message} isOpen={isOpen} handleModalClick={handleModalClick}
    />
  );

}

const MessageModel = props => {
  const { isOpen, iconName, headingInfo, message, handleModalClick } = props;

  return (
    <Modal basic open={isOpen} size='small'>
      <Header icon>
        <Icon name={iconName} />
        <b>{headingInfo}</b>
      </Header>
      <Modal.Content>
        <p>{message}</p>
      </Modal.Content>
      <Modal.Actions>
        <Button color='brown' inverted onClick={handleModalClick}>
          <Icon name='checkmark' /> OK
        </Button>
      </Modal.Actions>
    </Modal>
  );
}
export default AppMessage;