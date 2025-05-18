package hopshackle.spring_6_webapp.services;

import hopshackle.spring_6_webapp.domain.Magus;
import hopshackle.spring_6_webapp.repositories.MagusRepository;
import org.springframework.stereotype.Service;

@Service
public class MagusServiceImpl implements MagusService {

    private final MagusRepository magusRepository;

    public MagusServiceImpl(MagusRepository magusRepository) {
        this.magusRepository = magusRepository;
    }

    @Override
    public Iterable<Magus> findAll() {
        return magusRepository.findAll();
    }
}
