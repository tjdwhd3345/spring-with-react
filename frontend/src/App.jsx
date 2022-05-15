import './App.css';
import React, { useEffect, useState, useCallback } from 'react';
import CityList from './components/CityList/CityList';
import SearchBox from './components/SearchBox/SearchBox';

function App({ api }) {
  const [cityList, setCityList] = useState([]);
  const [countryCode, setCountryCode] = useState([]);

  async function fetchData() {
    const [result, countryCode] = await api.fetchAllCity();
    setCityList(() => result);
    setCountryCode(() => countryCode);
  }

  useEffect(() => {
    fetchData();
  }, []);

  const handleChange = useCallback(
    async (value) => {
      const result = await api.fetchCityByCode(value);
      setCityList(() => result);
    },
    [api]
  );

  return (
    <div className='App'>
      <header className='App-header'>
        This is CRUD Test page with Spring-React
      </header>
      <section className='App-section'>
        <div className='App-city-search'>
          <SearchBox countryCode={countryCode} handleChange={handleChange} />
        </div>
        <div className='App-city-wrap'>
          <CityList cityList={cityList} />
        </div>
      </section>
      <footer className='App-footer'>this is footer</footer>
    </div>
  );
}

export default App;
