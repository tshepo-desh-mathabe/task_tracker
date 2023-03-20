import APP_CONST from '../../utils/constants/app_contants.json';
import AddTask from '../task/AddTask';
import './Footer.scss';

 
const Footer = () => {
    return (
        <footer>
            <div className='add-task'>
                <AddTask />
            </div>
            <div className='footer-text'>
                <b>&copy; {APP_CONST.allRightsReserved}</b>
            </div>
        </footer>
    )
}

export default Footer;




