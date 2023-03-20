import React, { Fragment } from 'react';
import { Menu } from 'semantic-ui-react';
import NAME from '../../utils/constants/app_contants.json';

export const MenuItems = props => {
    const { item, handleItemClick } = props;

    return (
        <Fragment>
            <Menu.Item
                name={NAME.home}
                active={item === NAME.home}
                onClick={handleItemClick}
            />
            <Menu.Item
                name={NAME.defect}
                active={item === NAME.defect}
                onClick={handleItemClick}
            />
            <Menu.Item
                name={NAME.changeRequest}
                active={item === NAME.changeRequest}
                onClick={handleItemClick}
            />
            <Menu.Item
                name={NAME.userStory}
                active={item === NAME.userStory}
                onClick={handleItemClick}
            />
            <Menu.Item
                name={NAME.other}
                active={item === NAME.other}
                onClick={handleItemClick}
            />
        </Fragment>
    );
}