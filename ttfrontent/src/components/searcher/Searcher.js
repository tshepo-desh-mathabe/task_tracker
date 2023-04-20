import React from 'react'
import { Input, Icon, Form } from 'semantic-ui-react';
import FORM_CONST from '../../utils/constants/form_constants.json';

const Searcher = props => {
    const { label, searchValue, handleChange, handleSearch } = props;

    return (
        <Form.Field
            control={Input}
            label={label}
            placeholder={FORM_CONST.placeholder.search}
            name='search'
            value={searchValue}
            onChange={handleChange}
            icon={<Icon name='search' inverted circular link onClick={handleSearch} />}
        />
    );
}

export default Searcher;