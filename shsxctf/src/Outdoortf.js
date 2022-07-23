import IndividualResults from "./IndividualResults"
import MeetDropDown from "./MeetDropDown";
import MeetSeasonDropDown from "./MeetSeasonDropDown";

const Outdoortf = () => {
    const seas = "outdoor"
    return (
        <div>
            <MeetSeasonDropDown season={seas}/>
        </div>
    );
}
 
export default Outdoortf;