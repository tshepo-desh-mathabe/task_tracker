import React, { Component } from 'react';
import { Button, Icon, Modal } from 'semantic-ui-react';
import { DisplayFormWrapper } from '../../../utils/wrapper';
import TaskForm from '../TaskForm';
import APP_CONST from '../../../utils/constants/app_contants.json';
import { getAllFlagOptions } from '../../../utils/api/FlagOptionsService';

const initialState = {
    isOpen: false, dimmer: undefined, sendingFlag: false, taskId: '', taskType: '', statusType: '', priorityLevel: '',
    search: '', assignedTo: '', tasks: [], statuses: [], priorities: [], dueDate: '', dueTime: '', isBackend: false,
    isDatabase: false, description: '', comments: ''
}

export default class AddTask extends Component {
    constructor(props) {
        super(props);
        this.state = initialState;

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleCancel = this.handleCancel.bind(this);
        this.handleSearch = this.handleSearch.bind(this);
    }

    componentDidMount() {
        getAllFlagOptions().then(res => {
            console('res::', res);
        }, 
        err => console.log('err::', err));
    }

    handleChange = (e, data) => {
        e.preventDefault();
        this.state.sendingFlag ?
            this.setState({ [data.name]: data.value, sendingFlag: false }) : this.setState({ [data.name]: data.value });

        if (data.type === 'checkbox') {
            this.setState({ [data.name]: data.checked });
        }
    }

    handleSubmit(e) {
        e.preventDefault();
        console.log('--->>>', this.state);
    }

    handleCancel(e) {
        e.preventDefault();
        this.setState(initialState);
    }

    handleSearch() {
        console.log(this.state.search);
    }

    toggleModal = () => this.setState(state => ({ isOpen: !state.isOpen }));

    render() {
        const {
            isOpen, sendingFlag, taskId, taskType, statusType, priorityLevel, tasks, statuses, priorities, dueDate,
            dueTime, isBackend, isDatabase, description, comments, searchUser } = this.state;
        return (
            <div>
                <Button size='huge' animated='vertical' inverted color='brown'
                    onClick={this.toggleModal}>
                    <Button.Content hidden>
                        <Icon name='hand paper outline' size='big' />
                    </Button.Content>
                    <Button.Content visible>
                        <Icon name='add' size='big' />
                    </Button.Content>
                </Button>

                <Modal
                    dimmer='blurring'
                    open={isOpen}
                    onClose={this.toggleModal}
                >
                    <Modal.Content>
                        <DisplayForm
                            sendingFlag={sendingFlag} taskId={taskId} taskType={taskType} tasks={tasks} statusType={statusType} statuses={statuses}
                            priorityLevel={priorityLevel} priorities={priorities} dueDate={dueDate} dueTime={dueTime} isBackend={isBackend}
                            isDatabase={isDatabase} description={description} comments={comments} searchUser={searchUser} 
                            handleChange={this.handleChange} handleSubmit={this.handleSubmit} handleCancel={this.handleCancel} handleSearch={this.handleSearch}
                        />
                    </Modal.Content>
                </Modal>
            </div>
        );
    }
}

const DisplayForm = props => {
    const { sendingFlag, taskId, taskType, tasks, statusType, statuses, priorityLevel, priorities, dueDate, dueTime,
        isBackend, isDatabase, description, comments, searchUser, handleChange, handleSubmit, handleCancel, handleSearch } = props;

    return (
        <DisplayFormWrapper allowSecondButton={true} headerIcon='tasks' headerName={APP_CONST.createTask}
            submitButtonIcon='save' submitButtonName={APP_CONST.save} buttonIcon='cancel'
            buttonName={APP_CONST.cancel}
            formData={handleSubmit}
            handleButtonAction={handleCancel}
            children={
                <TaskForm
                    sendingFlag={sendingFlag} taskId={taskId} taskType={taskType} tasks={tasks} statusType={statusType} statuses={statuses}
                    priorityLevel={priorityLevel} priorities={priorities} dueDate={dueDate} dueTime={dueTime} isBackend={isBackend}
                    isDatabase={isDatabase} description={description} comments={comments} searchUser={searchUser} 
                    handleChange={handleChange} handleSearch={handleSearch}
                />
            }
        />
    );
}
