import CreateAnnoucement from "./CreateAnnoucement";
import UploadFiles from "./FileUploadPage";

const Dashboard = () => {
    return (
        <div>
            <h2>Dashboard</h2>
            <CreateAnnoucement/>
            <UploadFiles/>
        </div>
    );
}
 
export default Dashboard;