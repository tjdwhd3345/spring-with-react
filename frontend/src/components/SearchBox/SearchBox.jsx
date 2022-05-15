import React, { useState } from 'react';

const Searchbox = ({ countryCode, handleChange }) => {
  // const [countryValue, setCountryValue] = useState('');
  const onChange = (e) => {
    handleChange(e.target.value);
  };
  return (
    <div>
      <select
        name='countryCode'
        id='countryCode'
        onChange={onChange}
        // value={countryValue}
      >
        <option value='all' defaultValue={'all'}>
          전체
        </option>
        {countryCode.map((code, i) => (
          <option value={code} key={i}>
            {code}
          </option>
        ))}
      </select>
    </div>
  );
};

export default Searchbox;
