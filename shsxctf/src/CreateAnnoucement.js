import { useState } from "react";

async function submitAnnoucement(content) {
    return fetch('https://www.shsxctf.com/api/admin/announcement')
}






const CreateAnnoucement = () => {
    const [content, setContent] = useState();
    return (
        <div className="create">
            <form>
                <label>Announcement</label>
                <input type="text" size='100' onChange={e => setContent(e.target.value)}/>
                <button>Submit</button>
            </form>
        </div>
    );
}
 
export default CreateAnnoucement;