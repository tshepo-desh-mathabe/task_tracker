import isMobileByWidth from '../ScreenSizeDetection';

export const DisplayWrapper = props => {
    const { body } = props;

    return (
        <>
            {
                isMobileByWidth() ?
                    <div className='mobile-body-content'>{body}</div> :
                    <div className='desktop-body-content'>{body}</div>
            }
        </>
    );
}
