import { useState } from "react";

const CreateAnnoucement = () => {
    const [text, setText] = useState("");
    const [date, setDate] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        const annoucement = {text, date};
        
        fetch('https://www.shsxctf.com/api/admin/announcement', {
            method: 'POST',
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(annoucement)
        })
    }





    return (
        <div className="create">
            <form onSubmit={handleSubmit}>
                <label>Announcement</label>
                <input 
                type="text" 
                required
                value={text}
                size='100' 
                onChange={e => setText(e.target.value)}/>
                <label>Date</label>
                <input 
                type="text" 
                required
                value={date}
                size='20' 
                onChange={e => setDate(e.target.value)}/>
                <button>Submit</button>
            </form>
        </div>
    );
}
 
export default CreateAnnoucement;