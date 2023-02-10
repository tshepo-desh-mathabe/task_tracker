import { useState, useEffect } from 'react';
import APP_CONST from '../global/constants/app_contants.json';
import NUMBER from '../global/constants/number_constants.json';

function getDimensions() {
  const { innerWidth: width, innerHeight: height } = window;
  return {
    width, height
  };
}

function WindowDimensions() {
  const [windowDimensions, setWindowDimensions] = useState(getDimensions());

  useEffect(() => {
    function handleResize() {
      setWindowDimensions(getDimensions());
    }

    window.addEventListener(APP_CONST.screenResize, handleResize);
    return () => window.removeEventListener(APP_CONST.screenResize, handleResize);
  }, []);

  return windowDimensions;
}

export default function isMobileByWidth() {
  if (WindowDimensions().width <= NUMBER.mobileScreenSize) {
    return true;
  }
  return false
}
