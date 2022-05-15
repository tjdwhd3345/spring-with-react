import React, { memo } from 'react';
import styles from './CityList.module.css';

const City = memo(({ city }) => {
  const { name, countryCode, district, population } = city;
  return (
    <>
      <tr className={styles.citylist}>
        <td>{name}</td>
        <td>{countryCode}</td>
        <td>{district}</td>
        <td>{population}</td>
      </tr>
      {/* <li className={styles.citylist}>
        <p>{name}</p>
        <p>{countryCode}</p>
        <p>{district}</p>
        <p>{population}</p>
      </li> */}
    </>
  );
});

const CityList = ({ cityList }) => {
  return (
    <>
      <table className={styles.citywrap}>
        <thead className={styles.cityheader}>
          <tr>
            <th>name</th>
            <th>countryCode</th>
            <th>district</th>
            <th>population</th>
          </tr>
        </thead>
        <tbody>
          {cityList.map((city) => (
            <City city={city} key={city.id} />
          ))}
        </tbody>
      </table>
      {/* <ul className={styles.citywrap}>
        <li className={styles.cityheader}>
          <p>name</p>
          <p>countryCode</p>
          <p>district</p>
          <p>population</p>
        </li>
        {cityList.map((city) => (
          <City city={city} key={city.id} />
        ))}
      </ul> */}
    </>
  );
};

export default CityList;
