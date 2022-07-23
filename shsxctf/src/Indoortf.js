import IndividualResults from "./IndividualResults"
import MeetDropDown from "./MeetDropDown";
import MeetSeasonDropDown from "./MeetSeasonDropDown";

const Indoortf = () => {
    const seas = "indoor"
    return (
        <div>
            <MeetSeasonDropDown season={seas}/>
        </div>
    )
}
 
export default Indoortf;