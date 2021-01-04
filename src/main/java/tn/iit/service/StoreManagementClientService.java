package tn.iit.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import tn.iit.dto.MedicamentDto;
import tn.iit.link.Links;
import java.util.List;

@Service
public class StoreManagementClientService {
    private final RestTemplate restTemplate;

    public StoreManagementClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<MedicamentDto> getAllMedicaments(){
        UriComponents uriComponents= UriComponentsBuilder.fromUriString (Links.MEDICAMENTS).build ().encode ();
        return restTemplate.exchange (uriComponents.toUri (),
                HttpMethod.GET,
                new HttpEntity<> (null,new HttpHeaders ()),
                new ParameterizedTypeReference<List<MedicamentDto>> (){}).getBody ();
    }

    public MedicamentDto getMedicamentById(Long id){
        UriComponents uriComponents= UriComponentsBuilder.fromUriString (Links.MEDICAMENTS)
                .path ("/{id}")
                .build ()
                .expand (id)
                .encode ();
        return restTemplate.exchange (uriComponents.toUri (),
                HttpMethod.GET,
                new HttpEntity<> (null,new HttpHeaders ()),
                MedicamentDto.class).getBody ();
    }

    public List<MedicamentDto> getMedicamentsByIds(List<Long> ids){
        UriComponents uriComponents= UriComponentsBuilder.fromUriString (Links.MEDICAMENTS+"/searches")
                .build ()
                .encode ();
        return restTemplate.exchange (uriComponents.toUri (),
                HttpMethod.POST,
                new HttpEntity<> (ids,new HttpHeaders ()),
                new ParameterizedTypeReference<List<MedicamentDto>> (){}).getBody ();
    }
}
