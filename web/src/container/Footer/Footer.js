import React from 'react';
import { StyledFooter, StyledLogoName, StyledNetwoks, NetworkLogo, StyledRights } from './Footer.styled';
import insta from "./../../icons/insta.png"
import facebook from "./../../icons/facebook.png"


const Footer = () => { 
    return(
        <StyledFooter>
            <StyledLogoName>

            </StyledLogoName>
            <StyledNetwoks>
                <a href="https://www.instagram.com/"> <NetworkLogo src={insta} /> </a>
                <a href="https://www.facebook.com/"> <NetworkLogo src={facebook} /> </a>
            </StyledNetwoks>
            <StyledRights>
            </StyledRights>
        </StyledFooter>
        );
};

export default Footer;
