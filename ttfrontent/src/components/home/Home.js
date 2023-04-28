import appStore from '../../utils/store/AppStore';

export function Home() {
    appStore.setLoader({ flag: false, content: '' });
    return (
        <>
            <span>Home</span>
        </>
    );
}