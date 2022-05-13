import logo from './logo.svg';
import './App.css';
import React, { useEffect, useState } from 'react';

const City = ({ city }) => {
  const { name, countryCode, district, population } = city;
  return (
    <li>
      <p>name: {name}</p>
      <p>countryCode: {countryCode}</p>
      <p>district: {district}</p>
      <p>population: {population}</p>
    </li>
  );
};

function App() {
  const [cityList, setCityList] = useState([]);

  useEffect(() => {
    async function fetchData() {
      const result = await fetch('/city/all');
      const rj = await result.json();
      setCityList(() => rj);
    }
    fetchData();
  }, []);

  return (
    <div className='App'>
      <header className='App-header'>
        <img src={logo} className='App-logo' alt='logo' />
        <ul>
          {cityList.map((city) => (
            <City city={city} key={city.id} />
          ))}
        </ul>
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className='App-link'
          href='https://reactjs.org'
          target='_blank'
          rel='noopener noreferrer'
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
