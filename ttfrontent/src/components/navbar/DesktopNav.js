import React from 'react';
import { Menu } from 'semantic-ui-react';
import { MenuItems } from './MenuItems';

export const DesktopNav = props => {

    const { item, handleItemClick, children } = props;

    return (
        <React.Fragment>
            <Menu fixed='top' pointing secondary>
                <Menu.Menu>
                    <MenuItems item={item} handleItemClick={handleItemClick} />
                </Menu.Menu>
            </Menu>
            <div className='desktop-menu-items'>{children}</div>
        </React.Fragment>
    );
}
