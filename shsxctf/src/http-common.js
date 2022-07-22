import axios from "axios";
export default axios.create({
  baseURL: "https://shsxctf.com/api/admin/upload/schedule",
  headers: {
    "Content-type": "application/json"
  }
});
