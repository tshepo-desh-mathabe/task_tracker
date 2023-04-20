import appStore from "../../utils/store/AppStore"

export function Home() {
    appStore.setLoader({ flag: false, content: '' });
    console.log('--->>>>');
    return (
    <>
        {console.log('hello baby')}
        <span>Home</span>
        </>
    );
}