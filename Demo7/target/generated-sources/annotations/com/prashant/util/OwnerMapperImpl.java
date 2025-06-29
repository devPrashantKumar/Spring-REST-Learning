package com.prashant.util;

import com.prashant.dto.DomesticPetDTO;
import com.prashant.dto.OwnerDTO;
import com.prashant.dto.WildPetDTO;
import com.prashant.entity.DomesticPet;
import com.prashant.entity.Owner;
import com.prashant.entity.WildPet;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-29T15:53:23+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
@Component
public class OwnerMapperImpl implements OwnerMapper {

    @Override
    public Owner ownerDTOToOwner(OwnerDTO ownerDTO) {
        if ( ownerDTO == null ) {
            return null;
        }

        Owner owner = new Owner();

        owner.setPet( petDTOToPet( ownerDTO.getPetDTO() ) );
        owner.setFirstName( ownerDTO.getFirstName() );
        owner.setLastName( ownerDTO.getLastName() );
        owner.setGender( ownerDTO.getGender() );
        owner.setCity( ownerDTO.getCity() );
        owner.setState( ownerDTO.getState() );
        owner.setMobileNumber( ownerDTO.getMobileNumber() );
        owner.setEmailId( ownerDTO.getEmailId() );

        return owner;
    }

    @Override
    public DomesticPet domesticPetDTOToDomesticPet(DomesticPetDTO domesticPetDTO) {
        if ( domesticPetDTO == null ) {
            return null;
        }

        DomesticPet domesticPet = new DomesticPet();

        domesticPet.setName( domesticPetDTO.getName() );
        domesticPet.setGender( domesticPetDTO.getGender() );
        domesticPet.setType( domesticPetDTO.getType() );
        domesticPet.setBirthDate( domesticPetDTO.getBirthDate() );

        return domesticPet;
    }

    @Override
    public WildPet wildPetDTOToWildPet(WildPetDTO wildPetDTO) {
        if ( wildPetDTO == null ) {
            return null;
        }

        WildPet wildPet = new WildPet();

        wildPet.setName( wildPetDTO.getName() );
        wildPet.setGender( wildPetDTO.getGender() );
        wildPet.setType( wildPetDTO.getType() );
        wildPet.setBirthPlace( wildPetDTO.getBirthPlace() );

        return wildPet;
    }

    @Override
    public OwnerDTO ownerToOwnerDTO(Owner owner) {
        if ( owner == null ) {
            return null;
        }

        OwnerDTO.OwnerDTOBuilder ownerDTO = OwnerDTO.builder();

        ownerDTO.petDTO( petToPetDTO( owner.getPet() ) );
        ownerDTO.id( owner.getId() );
        ownerDTO.firstName( owner.getFirstName() );
        ownerDTO.lastName( owner.getLastName() );
        ownerDTO.gender( owner.getGender() );
        ownerDTO.city( owner.getCity() );
        ownerDTO.state( owner.getState() );
        ownerDTO.mobileNumber( owner.getMobileNumber() );
        ownerDTO.emailId( owner.getEmailId() );

        return ownerDTO.build();
    }

    @Override
    public DomesticPetDTO domesticPetToDomesticPetDTO(DomesticPet domesticPet) {
        if ( domesticPet == null ) {
            return null;
        }

        DomesticPetDTO.DomesticPetDTOBuilder domesticPetDTO = DomesticPetDTO.builder();

        domesticPetDTO.id( domesticPet.getId() );
        domesticPetDTO.name( domesticPet.getName() );
        domesticPetDTO.gender( domesticPet.getGender() );
        domesticPetDTO.type( domesticPet.getType() );
        domesticPetDTO.birthDate( domesticPet.getBirthDate() );

        return domesticPetDTO.build();
    }

    @Override
    public WildPetDTO wildPetToWildPetDTO(WildPet wildPet) {
        if ( wildPet == null ) {
            return null;
        }

        WildPetDTO.WildPetDTOBuilder wildPetDTO = WildPetDTO.builder();

        wildPetDTO.id( wildPet.getId() );
        wildPetDTO.name( wildPet.getName() );
        wildPetDTO.gender( wildPet.getGender() );
        wildPetDTO.type( wildPet.getType() );
        wildPetDTO.birthPlace( wildPet.getBirthPlace() );

        return wildPetDTO.build();
    }
}
