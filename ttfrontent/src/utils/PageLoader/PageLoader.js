import React from 'react';
import './PageLoader.scss';
import { Loader } from 'semantic-ui-react';

const PageLoader = props => {
  const { loaderInfo } = props;

  return (
    <div className='loader'>
      <div className='loader-content'>
        <Loader active inline size='huge' content={loaderInfo} />
      </div>
    </div>
  );
}

export default PageLoader;
