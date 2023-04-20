import APP_CONST from '../../constants/app_contants.json';

export function getPathWithParams(flag, paramsData) {
    switch (flag) {
        case APP_CONST.flag.deleteById:
            return `/delete/${paramsData}`;
        case APP_CONST.flag.getById:
            return `/get/${paramsData}`;
    }
}