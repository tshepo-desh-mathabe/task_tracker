import React from 'react';
import { Button, Header, Icon, Modal } from 'semantic-ui-react';
import { DisplayFormWrapper } from '../../utils/wrapper';
import { AddTaskForm } from './AddTaskForm';
import APP_CONST from '../../utils/constants/app_contants.json';

function modelActionReducer(state, action) {
    switch (action.type) {
        case 'OPEN_MODAL':
            return { open: true, dimmer: action.dimmer }
        case 'CLOSE_MODAL':
            return { open: false }
        default:
            throw new Error()
    }
}

function AddTask() {
    const [state, dispatch] = React.useReducer(modelActionReducer, {
        open: false,
        dimmer: undefined,
    })
    const { open, dimmer } = state

    return (
        <div>
            <Button size='huge' animated='vertical' inverted color='brown'
                onClick={() => dispatch({ type: 'OPEN_MODAL', dimmer: 'blurring' })}>
                <Button.Content hidden>
                    <Icon name='hand paper outline' size='big' />
                </Button.Content>
                <Button.Content visible>
                    <Icon name='add' size='big' />
                </Button.Content>
            </Button>

            <Modal
                dimmer={dimmer}
                open={open}
                onClose={() => dispatch({ type: 'CLOSE_MODAL' })}
            >
                <Modal.Content>
                    <DisplayForm />
                </Modal.Content>
                {/* <Modal.Actions>
                    <Button negative onClick={() => dispatch({ type: 'CLOSE_MODAL' })}>
                        Disagree
                    </Button>
                    <Button positive onClick={() => dispatch({ type: 'CLOSE_MODAL' })}>
                        Agree
                    </Button>
                </Modal.Actions> */}
            </Modal>
        </div>
    )
}

const DisplayForm = props => {
    return (
        <DisplayFormWrapper allowSecondButton={true} headerIcon='tasks' headerName={APP_CONST.createTask}
            submitButtonIcon='sign-in' submitButtonName={APP_CONST.signin} buttonIcon='cancel'
            buttonName={APP_CONST.cancel}
            formData={() => { }}
            handleButtonAction={() => { }}
            children={
                <>
                <AddTaskForm/>
                </>
            }
        />
    );
}
export default AddTask;