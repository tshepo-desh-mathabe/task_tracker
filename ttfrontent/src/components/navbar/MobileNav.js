import React from 'react';
import { Sidebar, Menu, Icon } from 'semantic-ui-react';
import { MenuItems } from './MenuItems';
import './Navbar.scss';

export const MobileNav = props => {

    const { children, onPusherClick, onToggle, visible, item, handleItemClick } = props;

    return (
        <Sidebar.Pushable>
            <Sidebar
                as={Menu}
                animation='overlay'
                icon='labeled'
                inverted
                direction='left'
                vertical
                visible={visible}
            >
                <MenuItems item={item} handleItemClick={handleItemClick} />
            </Sidebar>
            <Menu.Item onClick={onToggle}>
                <Icon name='sidebar' />
            </Menu.Item>
            <Sidebar.Pusher
                dimmed={visible}
                onClick={onPusherClick}
            >
                <Menu fixed='top' inverted>
                    <Menu.Item onClick={onToggle}>
                        <Icon name='sidebar' />
                    </Menu.Item>
                </Menu>
                <div className='mobile-menu-items'>{children}</div>
            </Sidebar.Pusher>
        </Sidebar.Pushable>
    );
}
