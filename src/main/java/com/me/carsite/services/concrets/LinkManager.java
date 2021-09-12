package com.me.carsite.services.concrets;

import com.me.carsite.services.abstracts.LinkService;
import com.me.carsite.dtos.LinkAddDto;
import com.me.carsite.models.Link;
import com.me.carsite.repositories.LinkRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LinkManager implements LinkService {
    private final LinkRepo linkRepo;
    private final ModelMapper modelMapper;

    @Override
    public LinkAddDto addLink(LinkAddDto linkAddDto) {
        Link link = modelMapper.map(linkAddDto,Link.class);
        return modelMapper.map(linkRepo.save(link),LinkAddDto.class);
    }
}
