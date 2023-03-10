import APP_CONST from '../../utils/constants/app_contants.json';

const Footer = () => {
    return (
        <footer style={{
            position: 'fixed',
            bottom: '0',
            left: '0',
            right: '0',
            textAlign: 'center',
            padding: '12px',
            backgroundColor: '#2a1f11',
            zIndex: 1,
            color: 'white'
        }}>
            <p><b>&copy; {APP_CONST.allRightsReserved}</b></p>
        </footer>
    )
}

export default Footer;




