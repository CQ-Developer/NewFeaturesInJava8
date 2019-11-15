package com.cq.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Optional;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class NewMan {

	private Optional<Goddess> goddess = Optional.empty();

}
