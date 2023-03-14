import React from 'react';
import { Button, Header, Icon, Modal } from 'semantic-ui-react';
import './Message.scss';

const AppMessage = props => {
  const { iconName, headingInfo, message, isOpen, handleModalClick } = props;

  return (
    <div className='container'>
      <div className='row'>
        <div className='col' />
        <div className='col'>
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
        </div>
        <div className='col' />
      </div>
    </div>
  );

}

export default AppMessage;