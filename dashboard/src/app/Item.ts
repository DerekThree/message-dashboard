export interface Item {
  name: {
    title: string;
    first: string;
    last: string;
  };
  phone: string;
  picture: {
    large: string;
    medium: string;
    thumbnail: string;
  };
  message: string;
  location: {
    street: {
      number: number;
      name: string;
    };
    city: string;
    state: string;
    postcode: number;
    country: string;
  };
  email: string;
}
