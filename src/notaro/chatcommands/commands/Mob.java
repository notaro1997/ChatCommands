package notaro.chatcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Mob implements CommandExecutor{
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String aliases, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage(ChatColor.RED + "This command can only be used in the chat!");
			return true;
		}
		Player player = (Player) sender;
		if((cmd.getName().equalsIgnoreCase("sm")) && (args.length == 1)){
			if(player.hasPermission("notaro.sm") || player.hasPermission("notaro.*")){
				org.bukkit.World world = player.getWorld();
				int x = player.getEyeLocation().getBlockX();
				int y = player.getEyeLocation().getBlockY();
				int z = player.getEyeLocation().getBlockZ();
				Location eye = new Location(world, x, y, z);
				String mob = String.valueOf(args[0]);
				if(mob.equalsIgnoreCase("cow")){
					player.getWorld().spawnCreature(eye, EntityType.COW);
				}else{
					if(mob.equalsIgnoreCase("chicken")){
						player.getWorld().spawnCreature(eye, EntityType.CHICKEN);
						return true;
					}else{
						if(mob.equalsIgnoreCase("wolf")){
							player.getWorld().spawnCreature(eye, EntityType.WOLF);
							return true;
						}else{
							if(mob.equalsIgnoreCase("sheep")){
								player.getWorld().spawnCreature(eye, EntityType.SHEEP);
								return true;
							}else{
								if(mob.equalsIgnoreCase("pig")){
									player.getWorld().spawnCreature(eye, EntityType.PIG);
									return true;
								}else{
									if(mob.equalsIgnoreCase("snowman")){
										player.getWorld().spawnCreature(eye, EntityType.SNOWMAN);
										return true;
									}else{
										if(mob.equalsIgnoreCase("squid")){
											player.getWorld().spawnCreature(eye, EntityType.SQUID);
											return true;
										}else{
											if(mob.equalsIgnoreCase("creeper")){
												player.getWorld().spawnCreature(eye, EntityType.CREEPER);
												return true;
											}else{
												if(mob.equalsIgnoreCase("spider")){
													player.getWorld().spawnCreature(eye, EntityType.SPIDER);
													return true;
												}else{
													if(mob.equalsIgnoreCase("cavespider")){
														player.getWorld().spawnCreature(eye, EntityType.CAVE_SPIDER);
														return true;
													}else{
														if(mob.equalsIgnoreCase("ghast")){
															player.getWorld().spawnCreature(eye, EntityType.GHAST);
															return true;
														}else{
															if(mob.equalsIgnoreCase("enderman")){
																player.getWorld().spawnCreature(eye, EntityType.ENDERMAN);
																return true;
															}else{
																if(mob.equalsIgnoreCase("enderdragon")){
																	player.getWorld().spawnCreature(eye, EntityType.ENDER_DRAGON);
																	return true;
																}else{
																	if(mob.equalsIgnoreCase("blaze")){
																		player.getWorld().spawnCreature(eye, EntityType.BLAZE);
																		return true;
																	}else{
																		if(mob.equalsIgnoreCase("magmacube")){
																			player.getWorld().spawnCreature(eye, EntityType.MAGMA_CUBE);
																			return true;
																		}else{
																			if(mob.equalsIgnoreCase("mooshroom")){
																				player.getWorld().spawnCreature(eye, EntityType.MUSHROOM_COW);
																				return true;
																			}else{
																				if(mob.equalsIgnoreCase("pigzombie")){
																					player.getWorld().spawnCreature(eye, EntityType.PIG_ZOMBIE);
																					return true;
																				}else{
																					if(mob.equalsIgnoreCase("silverfish")){
																						player.getWorld().spawnCreature(eye, EntityType.SILVERFISH);
																						return true;
																					}else{
																						if(mob.equalsIgnoreCase("skeleton")){
																							player.getWorld().spawnCreature(eye, EntityType.SKELETON);
																							return true;
																						}else{
																							if(mob.equalsIgnoreCase("slime")){
																								player.getWorld().spawnCreature(eye, EntityType.SLIME);
																							}else{
																								if(mob.equalsIgnoreCase("zombie")){
																									player.getWorld().spawnCreature(eye, EntityType.ZOMBIE);
																									return true;
																								}else{
																									if(mob.equalsIgnoreCase("crystal")){
																										player.getWorld().spawnEntity(eye, EntityType.ENDER_CRYSTAL);
																										return true;
																									}else{
																										if(mob.equalsIgnoreCase("giant")){
																											player.getWorld().spawnEntity(eye, EntityType.GIANT);
																											return true;
																										}else{
																											if(mob.equalsIgnoreCase("bat")){
																												player.getWorld().spawnCreature(eye, EntityType.BAT);
																												return true;
																											}else{
																												if(mob.equalsIgnoreCase("witch")){
																													player.getWorld().spawnCreature(eye, EntityType.WITCH);
																													return true;
																												}else{
																													if(mob.equalsIgnoreCase("wither")){
																														player.getWorld().spawnCreature(eye, EntityType.WITHER);
																														return true;
																													}else{
																														if(mob.equalsIgnoreCase("ocelot")){
																															player.getWorld().spawnCreature(eye, EntityType.OCELOT);
																															return true;
																														}else{
																															if(mob.equalsIgnoreCase("golem")){
																																player.getWorld().spawnCreature(eye, EntityType.IRON_GOLEM);
																																return true;

																															}else{
																																player.sendMessage(ChatColor.DARK_AQUA + "What mob is that?");
																																return true;
																															}
																														}
																													}
																												}
																											}
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}

			}else{
				return false;
			}
		}else{
			player.sendMessage(ChatColor.DARK_AQUA + "Correct syntax: /sm mobtype ");
			return true;
		}
		return false;
	}
}