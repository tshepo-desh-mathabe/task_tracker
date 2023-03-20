import React, { Component, Fragment } from 'react';
import { Container } from 'semantic-ui-react';
import history from '../../utils/BrowserHistory';
import { DesktopNav } from './DesktopNav';
import { MobileNav } from './MobileNav';
import APP_CONST from '../../utils/constants/app_contants.json';
import PATH from '../../utils/constants/route_path.json';
import NUMBER from '../../utils/constants/number_constants.json'; 

class NavigationBar extends Component {
    constructor(props) {
        super(props);
        this.state = {
            width: null,
            visible: false,
            activeItem: APP_CONST.defect,
        };

        if (window.performance) {
            if (performance.navigation.type === performance.navigation.TYPE_RELOAD) {
                sessionStorage.clear();
                history.push(history.location.pathname);
            }
        }
    }

    componentDidMount() {
        switch (history.location.pathname) {
            case PATH.home:
                this.setState({ activeItem: APP_CONST.home });
                break;
            case PATH.defect:
                this.setState({ activeItem: APP_CONST.defect });
                break;
            case PATH.changeRequest:
                this.setState({ activeItem: PATH.changeRequest });
                break;
            case PATH.userStory:
                this.setState({ activeItem: APP_CONST.userStory });
                break;
            case PATH.other:
                this.setState({ activeItem: PATH.other });
                break;
            default:
                this.setState({ activeItem: APP_CONST.defect });
                break;
        }

        window.addEventListener(APP_CONST.screenResize, this.handleResize.bind(this));
        this.handleResize();
    }

    handleResize() {
        this.setState({ width: window.innerWidth });
    }

    handlePusher = () => {
        const { visible } = this.state;

        if (visible) this.setState({ visible: false });
    };

    handleToggle = () => this.setState({ visible: !this.state.visible });

    /**
     * I am using semantic UI menu
     * Here I push the path for a browser route change
     */
    handleItemClick = (e, { name }) => {
        this.setState({ activeItem: name });

        switch (name) {
            case APP_CONST.home:  
                history.push(PATH.home);
                break;
            case APP_CONST.defect:
                history.push(PATH.defect);
                break;
            case APP_CONST.changeRequest:
                history.push(PATH.changeRequest);
                break;
            case APP_CONST.userStory:
                history.push(PATH.userStory);
                break;
            case APP_CONST.other:
                history.push(PATH.other);
                break;
            default:
                history.push(PATH.home);
                break;
        }
    }

    render() {
        const { activeItem } = this.state;

        return (
            <Fragment>
                {
                    this.state.width <= NUMBER.mobileScreenSize ?
                        <MobileNav
                            onToggle={this.handleToggle}
                            visible={this.state.visible}
                            onPusherClick={this.handlePusher}
                            item={activeItem}
                            handleItemClick={this.handleItemClick}
                        >
                            <NavBarChildren>{this.props.children}</NavBarChildren>
                        </MobileNav> :
                        <DesktopNav item={activeItem} handleItemClick={this.handleItemClick}>
                            <NavBarChildren>{this.props.children}</NavBarChildren>
                        </DesktopNav>
                }
            </Fragment>
        )
    }
}

const NavBarChildren = props => (
    <Container>{props.children}</Container>
);

export default NavigationBar;