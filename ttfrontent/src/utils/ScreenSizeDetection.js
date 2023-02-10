import { useState, useEffect } from 'react';
import number from '../global/constants/number_constants.json';

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

    window.addEventListener('resize', handleResize);
    return () => window.removeEventListener('resize', handleResize);
  }, []);

  return windowDimensions;
}

export default function isMobileByWidth() {
  if (WindowDimensions().width <= number.mobileScreenSize) {
    return true;
  }
  return false
}
