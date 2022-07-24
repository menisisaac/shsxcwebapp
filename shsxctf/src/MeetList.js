import { useState } from "react";
import IndividualResults from "./IndividualResults";

const MeetList = (props) => {
    const meets = props.meets;
    const [selectedMeet, setMeet] = useState('1');


    return (
    <div>
    <form>  

        <select
        value = {selectedMeet}
        onChange={(e) => setMeet(e.target.value)}
        >
            <option selected="Pick Meet">Pick Meet</option>
            {meets.filter(m => m.season == props.season).map((meet) => (
                <option value={meet.id}>{meet.name}</option>
            ))}
        </select>
    </form>
    <div className="result-line-list">
        <IndividualResults meetId={selectedMeet} />
    </div>
    </div>
    );
}
 
export default MeetList;