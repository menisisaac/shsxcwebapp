import axios from "axios";
export default axios.create({
  baseURL: "https://www.shsxctf.com/api/admin",
  headers: {
    "Content-type": "application/json"
  }
});
