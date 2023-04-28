package com.antitask.carpartshop.logic;

import lombok.AllArgsConstructor;
import com.antitask.carpartshop.model.Part;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class PartService {

    public static PartService with(List<Part> parts){
        return new PartService(parts);
    }
    /**
     * Parts loaded from data source
     */
    List<Part> parts;
    public List<Part> getPartsById(Integer partId) throws Exception {
        List<Part> result = new ArrayList<>();
        if (parts.size() == 0) {
            throw new Exception("Part list is empty");
        } else {
            parts.forEach(part -> {
                if (Objects.equals(part.getId(), Long.valueOf(partId))) {
                    result.add(part);
                }
            });
            if (result.size() == 0) {
                throw new Exception("No results by id");
            } else {
                return result;
            }
        }
    }
    public List<Part> getPartsByName(String partName) throws Exception {
        List<Part> result = new ArrayList<>();
        if (parts.size() == 0) {
            throw new Exception("Part list is empty");
        } else {
            parts.forEach(part -> {
                if (part.getName().equals(partName)) {
                    result.add(part);
                }
            });
            if (result.size() == 0) {
                throw new Exception("No results by name");
            } else {
                return result;
            }
        }
    }
    public List<Part> getPartsByUsage(boolean used) throws Exception {
        List<Part> result = new ArrayList<>();
        if (parts.size() == 0) {
            throw new Exception("Part list is empty");
        } else {
            parts.forEach(part -> {
                if (part.isUsed() == used) {
                    result.add(part);
                }
            });
            if (result.size() == 0) {
                throw new Exception("No results by usage");
            } else {
                return result;
            }
        }
    }
    public List<Part> getPartsByDateProduced(LocalDate dateProduced) throws Exception {
        List<Part> result = new ArrayList<>();
        if (parts.size() == 0) {
            throw new Exception("Part list is empty");
        } else {
            parts.forEach(part -> {
                if (part.getDateProduced().isEqual(dateProduced)) {
                    result.add(part);
                }
            });
            if (result.size() == 0) {
                throw new Exception("No results by data produced");
            } else {
                return result;
            }
        }
    }
    public List<Part> getPartsAfterDatesProduced(LocalDate dateProduced) throws Exception {
        List<Part> result = new ArrayList<>();
        if (parts.size() == 0) {
            throw new Exception("Part list is empty");
        } else {
            parts.forEach(part -> {
                if (part.getDateProduced().isAfter(dateProduced)) {
                    result.add(part);
                }
            });
            if (result.size() == 0) {
                throw new Exception("No results by after data produced");
            } else {
                return result;
            }
        }
    }
    public List<Part> getPartsBeforeDatesProduced(LocalDate dateProduced) throws Exception {
        List<Part> result = new ArrayList<>();
        if (parts.size() == 0) {
            throw new Exception("Part list is empty");
        } else {
            parts.forEach(part -> {
                if (part.getDateProduced().isBefore(dateProduced)) {
                    result.add(part);
                }
            });
            if (result.size() == 0) {
                throw new Exception("No results by before data produced");
            } else {
                return result;
            }
        }
    }
    public List<Part> getPartsBetweenDatesProduced(LocalDate startProduced, LocalDate endProduced) throws Exception {
        List<Part> result = new ArrayList<>();
        if (parts.size() == 0) {
            throw new Exception("Part list is empty");
        } else {
            parts.forEach(part -> {
                if (part.getDateProduced().isBefore(endProduced) && part.getDateProduced().isAfter(startProduced)) {
                    result.add(part);
                }
            });
            if (result.size() == 0) {
                throw new Exception("No results by between date produced");
            } else {
                return result;
            }
        }
    }

}
