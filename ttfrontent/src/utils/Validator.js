export function validateEmptyFields(flag, fieldValue) {
    if (fieldValue === null) {
        fieldValue = '';
    }
    return flag && fieldValue.length === 0;
}

export function dataChecker(value) {
    if (value === null) {
        return false;
    } else if (value.length === 0) {
        return false;
    } else {
        return true;
    }
}

export function validateEmail(flag, email) {
    let checker = true;
    /* eslint-disable */
    if (emailRegex(email)) {
        checker = false;
    }
    
    return flag && checker;
}

export function emailRegex(testValue) {
    /* eslint-disable */
    return /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(testValue);
}