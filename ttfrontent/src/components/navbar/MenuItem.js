import NAME from '../../global/constants/app_contants.json';

export const GeneralItem = props => {
    const { item, handleItemClick } = props;

    return (
        <Fragment>
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