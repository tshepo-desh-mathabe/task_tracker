import React, { Fragment } from 'react';
import { Form, Input, Grid, Image } from 'semantic-ui-react';
import FORM_CONST from '../../utils/constants/form_constants.json';
import { validateEmptyFields, validateEmail } from '../../utils/Validator';

const placeholder = FORM_CONST.placeholder;
const label = FORM_CONST.label;
const error = FORM_CONST.error;

export const AddTaskForm = props => {

    return (
        <Form>
            <Form.Group widths='equal'>
                <Form.Input fluid label='First name' placeholder='Read only' readOnly />
                <Form.Input fluid label='Last name' placeholder='Read only' readOnly />
            </Form.Group>
        </Form>
    );
}