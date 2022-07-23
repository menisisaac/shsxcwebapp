import IndividualResults from "./IndividualResults"
import MeetDropDown from "./MeetDropDown";
import MeetSeasonDropDown from "./MeetSeasonDropDown";

const CrossCountry = () => {
    const seas = "xc"
    return (
        <div>
            <MeetSeasonDropDown season={seas}/>
        </div>
    );
}
 
export default CrossCountry;