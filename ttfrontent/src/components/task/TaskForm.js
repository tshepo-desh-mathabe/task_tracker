import React, { Fragment } from 'react';
import { Form, Input, Grid, Checkbox, TextArea, Select } from 'semantic-ui-react';
import FORM_CONST from '../../utils/constants/form_constants.json';
import { validateEmptyFields } from '../../utils/Validator';
import Searcher from '../searcher/Searcher';

const placeholder = FORM_CONST.placeholder;
const label = FORM_CONST.label;
const error = FORM_CONST.error;

const genderOptions = [
    { key: 'm', text: 'Male', value: 'male' },
    { key: 'f', text: 'Female', value: 'female' },
    { key: 'o', text: 'Other', value: 'other' },
]

const TaskForm = props => {
    const { sendingFlag, taskId, taskType, tasks, statusType, statuses, priorityLevel, priorities, dueDate, dueTime,
        isBackend, isDatabase, description, comments, handleChange, handleSearch, searchUser } = props;

    return (
        <Fragment>
            <DisplayHelper
                elem1={
                    <Form.Field
                        control={Input}
                        type="number"
                        label={label.taskId}
                        placeholder={placeholder.taskId}
                        name='taskId'
                        value={taskId}
                        onChange={handleChange}
                    // validate and make sire it is a number
                    // error={validateEmptyFields(sendingFlag, taskId) && {
                    //     content: error.fillEmptyFields
                    // }}
                    />
                }
                elem2={
                    <Form.Field
                        control={Input}
                        label={label.dueDate}
                        placeholder={placeholder.dueDate}
                        name='dueDate'
                        value={dueDate}
                        onChange={handleChange}
                    // validate and make sure it is a date fomat
                    // error={validateEmptyFields(sendingFlag, taskId) && {
                    //     content: error.fillEmptyFields
                    // }}
                    />
                }
                elem3={
                    <Form.Field
                        control={Input}
                        label={label.dueTime}
                        placeholder={placeholder.dueTime}
                        name='dueTime'
                        value={dueTime}
                        onChange={handleChange}
                    // validate and make sure it is a time fomat
                    // error={validateEmptyFields(sendingFlag, dueTime) && {
                    //     content: error.fillEmptyFields
                    // }}
                    />
                }
            />

            <DisplayHelper
                elem1={
                    <Form.Field
                        control={Select}
                        options={genderOptions}
                        label={{ children: `${label.taskType}`, htmlFor: 'form-select-control' }}
                        placeholder={placeholder.select}
                        name='taskType'
                        search
                        searchInput={{ id: 'form-select-control' }}
                        value={taskType}
                        onChange={handleChange}
                    />
                }
                elem2={
                    <Form.Field
                        control={Select}
                        options={genderOptions}
                        label={{ children: `${label.status}`, htmlFor: 'form-select-control' }}
                        placeholder={placeholder.select}
                        name='statusType'
                        search
                        searchInput={{ id: 'form-select-control' }}
                        value={statusType}
                        onChange={handleChange}
                    />
                }
                elem3={
                    <Form.Field
                        control={Select}
                        options={genderOptions}
                        label={{ children: `${label.priority}`, htmlFor: 'form-select-control' }}
                        placeholder={placeholder.select}
                        name='priorityLevel'
                        search
                        searchInput={{ id: 'form-select-control' }}
                        value={priorityLevel}
                        onChange={handleChange}
                    />
                }
            />

            <DisplayHelper
                elem1={
                    <Searcher
                        label={label.assignedTo}
                        searchValue={searchUser}
                        handleChange={handleChange}
                        handleSearch={handleSearch} />
                }

                elem2={
                    <Fragment>
                    <Form.Field
                        control={Checkbox}
                        toggle
                        label={label.isBackend}
                        name='isBackend'
                        checked={isBackend}
                        onClick={handleChange}
                    />
                    <Form.Field
                        control={Checkbox}
                        toggle
                        label={label.isDatabase}
                        name='isDatabase'
                        checked={isDatabase}
                        onClick={handleChange}
                    />
                    </Fragment>
                }
                elem3={
                    <></>
                }
            />
            <br />

            <Form.Field
                control={TextArea}
                label={label.description}
                placeholder={placeholder.more}
                name='description'
                value={description}
                onChange={handleChange}
            // validate and make sure it is a date fomat
            // error={validateEmptyFields(sendingFlag, taskId) && {
            //     content: error.fillEmptyFields
            // }}
            />
            <Form.Field
                control={TextArea}
                label={label.comments}
                placeholder={placeholder.more}
                name='comments'
                value={comments}
                onChange={handleChange}
            // validate and make sure it is a date fomat
            // error={validateEmptyFields(sendingFlag, taskId) && {
            //     content: error.fillEmptyFields
            // }}
            />
        </Fragment>
    );
}

const DisplayHelper = props => {
    const { elem1, elem2, elem3 } = props;

    return (
        <Grid columns={3}stackable>
            <Grid.Row>
                <Grid.Column>
                    {elem1}
                </Grid.Column>
                <Grid.Column>
                    {elem2}
                </Grid.Column>
                <Grid.Column>
                    {elem3}
                </Grid.Column>
            </Grid.Row>
        </Grid>
    );
}

export default TaskForm;