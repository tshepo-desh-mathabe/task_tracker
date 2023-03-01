import React, { Fragment } from 'react';
import { Form, Input } from 'semantic-ui-react';
import FORM_CONST from '../../utils/constants/form_constants.json';
import { validateEmptyFields, validateEmail } from '../../utils/Validator';

const placeholder = FORM_CONST.placeholder;
const label = FORM_CONST.label;
const error = FORM_CONST.error;

export const LoginForm = props => {     
    const { sendingFlag, emailAddress, password, handleChange } = props;

    return (
        <Fragment>
            <Form.Field
                control={Input}
                label={label.email}
                placeholder={placeholder.email}
                name='emailAddress'
                value={emailAddress}
                onChange={handleChange}
                error={validateEmail(sendingFlag, emailAddress) && {
                    content: error.emailAddress
                }}
            />
            <Form.Field
                control={Input}
                type='password'
                label={label.password}
                placeholder={FORM_CONST.password}
                name='password'
                value={password}
                onChange={handleChange}
                error={validateEmptyFields(sendingFlag, password) && {
                    content: FORM_CONST.password
                }}
            />
        </Fragment>
    );
}