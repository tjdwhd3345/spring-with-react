class Api {
  async fetchAllCity() {
    const data = await fetch('/city/all');
    const result = await data.json();
    const countryCode = result.reduce(
      (p, c) => (p.includes(c.countryCode) ? p : [...p, c.countryCode]),
      []
    );
    return [result, countryCode];
  }

  async fetchCityByCode(countryCode) {
    const result = await fetch(`/city/${countryCode}`);
    return await result.json();
  }
}

export default Api;
