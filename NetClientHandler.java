import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.client.Minecraft;

public class NetClientHandler extends oe {
   private boolean f = false;
   private lg g;
   public String a;
   private Minecraft h;
   private WorldClient i;
   private boolean j = false;
   public za b = new za(null);
   private Map k = new HashMap();
   public List c = new ArrayList();
   public int d = 20;
   Random e = new Random();

   public NetClientHandler(Minecraft par1Minecraft, String par2Str, int par3) throws UnknownHostException, IOException {
      this.h = par1Minecraft;
      Socket socket = new Socket(InetAddress.getByName(par2Str), par3);
      this.g = new lg(socket, "Client", this);
   }

   public void b() {
      if (!this.f) {
         this.g.b();
      }

      this.g.a();
   }

   public void a(aec par1Packet1Login) {
      this.h.c = new PlayerControllerMP(this.h, this);
      this.h.K.a(gv.i, 1);
      this.i = new WorldClient(this, new fj(0L, par1Packet1Login.d, false, false, par1Packet1Login.c), par1Packet1Login.e, par1Packet1Login.f);
      this.i.F = true;
      this.h.a(this.i);
      this.h.h.aB = par1Packet1Login.e;
      this.h.a(new ez(this));
      this.h.h.f = par1Packet1Login.a;
      this.d = par1Packet1Login.h;
      ((PlayerControllerMP)this.h.c).a(par1Packet1Login.d == 1);
   }

   public void a(Packet21PickupSpawn par1Packet21PickupSpawn) {
      double d = par1Packet21PickupSpawn.b / 32.0;
      double d1 = par1Packet21PickupSpawn.c / 32.0;
      double d2 = par1Packet21PickupSpawn.d / 32.0;
      EntityItem entityitem = new EntityItem(this.i, d, d1, d2, new ItemStack(par1Packet21PickupSpawn.h, par1Packet21PickupSpawn.i, par1Packet21PickupSpawn.j));
      entityitem.r = par1Packet21PickupSpawn.e / 128.0;
      entityitem.s = par1Packet21PickupSpawn.f / 128.0;
      entityitem.t = par1Packet21PickupSpawn.g / 128.0;
      entityitem.ah = par1Packet21PickupSpawn.b;
      entityitem.ai = par1Packet21PickupSpawn.c;
      entityitem.aj = par1Packet21PickupSpawn.d;
      this.i.a(par1Packet21PickupSpawn.a, entityitem);
   }

   public void a(Packet23VehicleSpawn par1Packet23VehicleSpawn) {
      double d = par1Packet23VehicleSpawn.b / 32.0;
      double d1 = par1Packet23VehicleSpawn.c / 32.0;
      double d2 = par1Packet23VehicleSpawn.d / 32.0;
      Entity obj = null;
      if (par1Packet23VehicleSpawn.h == 10) {
         obj = new EntityMinecart(this.i, d, d1, d2, 0);
      } else if (par1Packet23VehicleSpawn.h == 11) {
         obj = new EntityMinecart(this.i, d, d1, d2, 1);
      } else if (par1Packet23VehicleSpawn.h == 12) {
         obj = new EntityMinecart(this.i, d, d1, d2, 2);
      } else if (par1Packet23VehicleSpawn.h == 90) {
         obj = new EntityFishHook(this.i, d, d1, d2);
      } else if (par1Packet23VehicleSpawn.h == 60) {
         obj = new EntityArrow(this.i, d, d1, d2);
      } else if (par1Packet23VehicleSpawn.h == 61) {
         obj = new uq(this.i, d, d1, d2);
      } else if (par1Packet23VehicleSpawn.h == 65) {
         obj = new adw(this.i, d, d1, d2);
      } else if (par1Packet23VehicleSpawn.h == 72) {
         obj = new EntityEnderEye(this.i, d, d1, d2);
      } else if (par1Packet23VehicleSpawn.h == 63) {
         obj = new EntityFireball(this.i, d, d1, d2, par1Packet23VehicleSpawn.e / 8000.0, par1Packet23VehicleSpawn.f / 8000.0, par1Packet23VehicleSpawn.g / 8000.0);
         par1Packet23VehicleSpawn.i = 0;
      } else if (par1Packet23VehicleSpawn.h == 64) {
         obj = new EntitySmallFireball(this.i, d, d1, d2, par1Packet23VehicleSpawn.e / 8000.0, par1Packet23VehicleSpawn.f / 8000.0, par1Packet23VehicleSpawn.g / 8000.0);
         par1Packet23VehicleSpawn.i = 0;
      } else if (par1Packet23VehicleSpawn.h == 62) {
         obj = new qe(this.i, d, d1, d2);
      } else if (par1Packet23VehicleSpawn.h == 73) {
         obj = new EntityPotion(this.i, d, d1, d2, par1Packet23VehicleSpawn.i);
         par1Packet23VehicleSpawn.i = 0;
      } else if (par1Packet23VehicleSpawn.h == 75) {
         obj = new EntityExpBottle(this.i, d, d1, d2);
         par1Packet23VehicleSpawn.i = 0;
      } else if (par1Packet23VehicleSpawn.h == 1) {
         obj = new EntityBoat(this.i, d, d1, d2);
      } else if (par1Packet23VehicleSpawn.h == 50) {
         obj = new agg(this.i, d, d1, d2);
      } else if (par1Packet23VehicleSpawn.h == 51) {
         obj = new EntityEnderCrystal(this.i, d, d1, d2);
      } else if (par1Packet23VehicleSpawn.h == 70) {
         obj = new EntityFallingSand(this.i, d, d1, d2, Block.E.bO);
      } else if (par1Packet23VehicleSpawn.h == 71) {
         obj = new EntityFallingSand(this.i, d, d1, d2, Block.F.bO);
      } else if (par1Packet23VehicleSpawn.h == 74) {
         obj = new EntityFallingSand(this.i, d, d1, d2, Block.bK.bO);
      }

      if (obj != null) {
         obj.ah = par1Packet23VehicleSpawn.b;
         obj.ai = par1Packet23VehicleSpawn.c;
         obj.aj = par1Packet23VehicleSpawn.d;
         obj.u = 0.0F;
         obj.v = 0.0F;
         Entity[] aentity = obj.Z();
         if (aentity != null) {
            int i = par1Packet23VehicleSpawn.a - obj.f;

            for (int j = 0; j < aentity.length; j++) {
               aentity[j].f += i;
            }
         }

         obj.f = par1Packet23VehicleSpawn.a;
         this.i.a(par1Packet23VehicleSpawn.a, obj);
         if (par1Packet23VehicleSpawn.i > 0) {
            if (par1Packet23VehicleSpawn.h == 60) {
               Entity entity = this.a(par1Packet23VehicleSpawn.i);
               if (entity instanceof EntityLiving) {
                  ((EntityArrow)obj).c = (EntityLiving)entity;
               }
            }

            obj.a(par1Packet23VehicleSpawn.e / 8000.0, par1Packet23VehicleSpawn.f / 8000.0, par1Packet23VehicleSpawn.g / 8000.0);
         }
      }
   }

   public void a(Packet26EntityExpOrb par1Packet26EntityExpOrb) {
      EntityXPOrb entityxporb = new EntityXPOrb(this.i, par1Packet26EntityExpOrb.b, par1Packet26EntityExpOrb.c, par1Packet26EntityExpOrb.d, par1Packet26EntityExpOrb.e);
      entityxporb.ah = par1Packet26EntityExpOrb.b;
      entityxporb.ai = par1Packet26EntityExpOrb.c;
      entityxporb.aj = par1Packet26EntityExpOrb.d;
      entityxporb.u = 0.0F;
      entityxporb.v = 0.0F;
      entityxporb.f = par1Packet26EntityExpOrb.a;
      this.i.a(par1Packet26EntityExpOrb.a, entityxporb);
   }

   public void a(Packet71Weather par1Packet71Weather) {
      double d = par1Packet71Weather.b / 32.0;
      double d1 = par1Packet71Weather.c / 32.0;
      double d2 = par1Packet71Weather.d / 32.0;
      d entitylightningbolt = null;
      if (par1Packet71Weather.e == 1) {
         entitylightningbolt = new d(this.i, d, d1, d2);
      }

      if (entitylightningbolt != null) {
         entitylightningbolt.ah = par1Packet71Weather.b;
         entitylightningbolt.ai = par1Packet71Weather.c;
         entitylightningbolt.aj = par1Packet71Weather.d;
         entitylightningbolt.u = 0.0F;
         entitylightningbolt.v = 0.0F;
         entitylightningbolt.f = par1Packet71Weather.a;
         this.i.e(entitylightningbolt);
      }
   }

   public void a(Packet25EntityPainting par1Packet25EntityPainting) {
      EntityPainting entitypainting = new EntityPainting(
         this.i,
         par1Packet25EntityPainting.b,
         par1Packet25EntityPainting.c,
         par1Packet25EntityPainting.d,
         par1Packet25EntityPainting.e,
         par1Packet25EntityPainting.f
      );
      this.i.a(par1Packet25EntityPainting.a, entitypainting);
   }

   public void a(yn par1Packet28EntityVelocity) {
      Entity entity = this.a(par1Packet28EntityVelocity.a);
      if (entity != null) {
         entity.a(par1Packet28EntityVelocity.b / 8000.0, par1Packet28EntityVelocity.c / 8000.0, par1Packet28EntityVelocity.d / 8000.0);
      }
   }

   public void a(pf par1Packet40EntityMetadata) {
      Entity entity = this.a(par1Packet40EntityMetadata.a);
      if (entity != null && par1Packet40EntityMetadata.b() != null) {
         entity.y().a(par1Packet40EntityMetadata.b());
      }
   }

   public void a(Packet20NamedEntitySpawn par1Packet20NamedEntitySpawn) {
      double d = par1Packet20NamedEntitySpawn.c / 32.0;
      double d1 = par1Packet20NamedEntitySpawn.d / 32.0;
      double d2 = par1Packet20NamedEntitySpawn.e / 32.0;
      float f = par1Packet20NamedEntitySpawn.f * 360 / 256.0F;
      float f1 = par1Packet20NamedEntitySpawn.g * 360 / 256.0F;
      rv entityotherplayermp = new rv(this.h.f, par1Packet20NamedEntitySpawn.b);
      entityotherplayermp.l = entityotherplayermp.N = entityotherplayermp.ah = par1Packet20NamedEntitySpawn.c;
      entityotherplayermp.m = entityotherplayermp.O = entityotherplayermp.ai = par1Packet20NamedEntitySpawn.d;
      entityotherplayermp.n = entityotherplayermp.P = entityotherplayermp.aj = par1Packet20NamedEntitySpawn.e;
      int i = par1Packet20NamedEntitySpawn.h;
      if (i == 0) {
         entityotherplayermp.ap.a[entityotherplayermp.ap.c] = null;
      } else {
         entityotherplayermp.ap.a[entityotherplayermp.ap.c] = new ItemStack(i, 1, 0);
      }

      entityotherplayermp.b(d, d1, d2, f, f1);
      this.i.a(par1Packet20NamedEntitySpawn.a, entityotherplayermp);
   }

   public void a(Packet34EntityTeleport par1Packet34EntityTeleport) {
      Entity entity = this.a(par1Packet34EntityTeleport.a);
      if (entity != null) {
         entity.ah = par1Packet34EntityTeleport.b;
         entity.ai = par1Packet34EntityTeleport.c;
         entity.aj = par1Packet34EntityTeleport.d;
         double d = entity.ah / 32.0;
         double d1 = entity.ai / 32.0 + 0.015625;
         double d2 = entity.aj / 32.0;
         float f = par1Packet34EntityTeleport.e * 360 / 256.0F;
         float f1 = par1Packet34EntityTeleport.f * 360 / 256.0F;
         entity.a(d, d1, d2, f, f1, 3);
      }
   }

   public void a(aip par1Packet30Entity) {
      Entity entity = this.a(par1Packet30Entity.a);
      if (entity != null) {
         entity.ah = entity.ah + par1Packet30Entity.b;
         entity.ai = entity.ai + par1Packet30Entity.c;
         entity.aj = entity.aj + par1Packet30Entity.d;
         double d = entity.ah / 32.0;
         double d1 = entity.ai / 32.0;
         double d2 = entity.aj / 32.0;
         float f = par1Packet30Entity.g ? par1Packet30Entity.e * 360 / 256.0F : entity.u;
         float f1 = par1Packet30Entity.g ? par1Packet30Entity.f * 360 / 256.0F : entity.v;
         entity.a(d, d1, d2, f, f1, 3);
      }
   }

   public void a(aji par1Packet35EntityHeadRotation) {
      Entity entity = this.a(par1Packet35EntityHeadRotation.a);
      if (entity != null) {
         float f = par1Packet35EntityHeadRotation.b * 360 / 256.0F;
         entity.f(f);
      }
   }

   public void a(agx par1Packet29DestroyEntity) {
      this.i.b(par1Packet29DestroyEntity.a);
   }

   public void a(gg par1Packet10Flying) {
      EntityPlayerSP entityplayersp = this.h.h;
      double d = entityplayersp.o;
      double d1 = entityplayersp.p;
      double d2 = entityplayersp.q;
      float f = entityplayersp.u;
      float f1 = entityplayersp.v;
      if (par1Packet10Flying.h) {
         d = par1Packet10Flying.a;
         d1 = par1Packet10Flying.b;
         d2 = par1Packet10Flying.c;
      }

      if (par1Packet10Flying.i) {
         f = par1Packet10Flying.e;
         f1 = par1Packet10Flying.f;
      }

      entityplayersp.Q = 0.0F;
      entityplayersp.r = entityplayersp.s = entityplayersp.t = 0.0;
      entityplayersp.b(d, d1, d2, f, f1);
      par1Packet10Flying.a = entityplayersp.o;
      par1Packet10Flying.b = entityplayersp.y.b;
      par1Packet10Flying.c = entityplayersp.q;
      par1Packet10Flying.d = entityplayersp.p;
      this.g.a(par1Packet10Flying);
      if (!this.j) {
         this.h.h.l = this.h.h.o;
         this.h.h.m = this.h.h.p;
         this.h.h.n = this.h.h.q;
         this.j = true;
         this.h.a((vp)null);
      }
   }

   public void a(Packet50PreChunk par1Packet50PreChunk) {
      this.i.doPreChunk(par1Packet50PreChunk.a, par1Packet50PreChunk.b, par1Packet50PreChunk.c);
   }

   public void a(Packet52MultiBlockChange par1Packet52MultiBlockChange) {
      long i = par1Packet52MultiBlockChange.a * 16L;
      long j = par1Packet52MultiBlockChange.b * 16L;
      if (par1Packet52MultiBlockChange.c != null) {
         DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(par1Packet52MultiBlockChange.c));

         try {
            for (int k = 0; k < par1Packet52MultiBlockChange.d; k++) {
               short word0 = datainputstream.readShort();
               short word1 = datainputstream.readShort();
               int l = (word1 & 4095) >> 4;
               int i1 = word1 & 15;
               int j1 = word0 >> 12 & 15;
               int k1 = word0 >> 8 & 15;
               int l1 = word0 & 255;
               this.i.setBlockAndMetadataAndInvalidate(j1 + i, l1, k1 + j, l, i1);
            }
         } catch (IOException var15) {
         }
      }
   }

   public void a(Packet51MapChunk par1Packet51MapChunk) {
      this.i
         .invalidateBlockReceiveRegion(
            par1Packet51MapChunk.a << 4, 0, par1Packet51MapChunk.b << 4, (par1Packet51MapChunk.a << 4) + 15L, 256, (par1Packet51MapChunk.b << 4) + 15L
         );
      Chunk chunk = this.i.getChunkFromChunkCoords(par1Packet51MapChunk.a, par1Packet51MapChunk.b);
      if (par1Packet51MapChunk.f && chunk == null) {
         this.i.doPreChunk(par1Packet51MapChunk.a, par1Packet51MapChunk.b, true);
         chunk = this.i.getChunkFromChunkCoords(par1Packet51MapChunk.a, par1Packet51MapChunk.b);
      }

      if (chunk != null) {
         chunk.a(par1Packet51MapChunk.e, par1Packet51MapChunk.c, par1Packet51MapChunk.d, par1Packet51MapChunk.f);
         this.i
            .markBlocksDirty(
               par1Packet51MapChunk.a << 4, 0, par1Packet51MapChunk.b << 4, (par1Packet51MapChunk.a << 4) + 15L, 256, (par1Packet51MapChunk.b << 4) + 15L
            );
         if (!par1Packet51MapChunk.f || !(this.i.t instanceof ms)) {
            chunk.n();
         }
      }
   }

   public void a(Packet53BlockChange par1Packet53BlockChange) {
      this.i
         .setBlockAndMetadataAndInvalidate(
            par1Packet53BlockChange.a, par1Packet53BlockChange.b, par1Packet53BlockChange.c, par1Packet53BlockChange.d, par1Packet53BlockChange.e
         );
   }

   public void a(amg par1Packet255KickDisconnect) {
      this.g.a("disconnect.kicked", new Object[0]);
      this.f = true;
      this.h.a((World)null);
      this.h.a(new dw("disconnect.disconnected", "disconnect.genericReason", new Object[]{par1Packet255KickDisconnect.a}));
   }

   public void a(String par1Str, Object[] par2ArrayOfObj) {
      if (!this.f) {
         this.f = true;
         this.h.a((World)null);
         this.h.a(new dw("disconnect.lost", par1Str, par2ArrayOfObj));
      }
   }

   public void b(abs par1Packet) {
      if (!this.f) {
         this.g.a(par1Packet);
         this.g.c();
      }
   }

   public void c(abs par1Packet) {
      if (!this.f) {
         this.g.a(par1Packet);
      }
   }

   public void a(vv par1Packet22Collect) {
      Entity entity = this.a(par1Packet22Collect.a);
      Object obj = (EntityLiving)this.a(par1Packet22Collect.b);
      if (obj == null) {
         obj = this.h.h;
      }

      if (entity != null) {
         if (entity instanceof EntityXPOrb) {
            this.i.a(entity, "random.orb", 0.2F, ((this.e.nextFloat() - this.e.nextFloat()) * 0.7F + 1.0F) * 2.0F);
         } else {
            this.i.a(entity, "random.pop", 0.2F, ((this.e.nextFloat() - this.e.nextFloat()) * 0.7F + 1.0F) * 2.0F);
         }

         this.h.j.a(new EntityPickupFX(this.h.f, entity, (Entity)obj, -0.5F));
         this.i.b(par1Packet22Collect.a);
      }
   }

   public void a(afd par1Packet3Chat) {
      this.h.w.a(par1Packet3Chat.a);
   }

   public void a(kc par1Packet18Animation) {
      Entity entity = this.a(par1Packet18Animation.a);
      if (entity != null) {
         if (par1Packet18Animation.b == 1) {
            EntityPlayer entityplayer = (EntityPlayer)entity;
            entityplayer.EntityAIAttackOnCollide();
         } else if (par1Packet18Animation.b == 2) {
            entity.k();
         } else if (par1Packet18Animation.b == 3) {
            EntityPlayer entityplayer1 = (EntityPlayer)entity;
            entityplayer1.a(false, false, false);
         } else if (par1Packet18Animation.b == 4) {
            EntityPlayer entityplayer2 = (EntityPlayer)entity;
            entityplayer2.ab();
         } else if (par1Packet18Animation.b == 6) {
            this.h.j.a(new EntityCrit2FX(this.h.f, entity));
         } else if (par1Packet18Animation.b == 7) {
            EntityCrit2FX entitycrit2fx = new EntityCrit2FX(this.h.f, entity, "magicCrit");
            this.h.j.a(entitycrit2fx);
         } else if (par1Packet18Animation.b == 5 && !(entity instanceof rv)) {
         }
      }
   }

   public void a(Packet17Sleep par1Packet17Sleep) {
      Entity entity = this.a(par1Packet17Sleep.a);
      if (entity != null) {
         if (par1Packet17Sleep.e == 0) {
            EntityPlayer entityplayer = (EntityPlayer)entity;
            entityplayer.sleepInBedAt(par1Packet17Sleep.b, par1Packet17Sleep.c, par1Packet17Sleep.d);
         }
      }
   }

   public void a(jf par1Packet2Handshake) {
      boolean flag = true;
      String s = par1Packet2Handshake.a;
      if (s == null || s.trim().length() == 0) {
         flag = false;
      } else if (!s.equals("-")) {
         try {
            Long.parseLong(s, 16);
         } catch (NumberFormatException numberformatexception) {
            flag = false;
         }
      }

      if (!flag) {
         this.g.a("disconnect.genericReason", new Object[]{"The server responded with MapGenVillage invalid server key"});
      } else if (par1Packet2Handshake.a.equals("-")) {
         this.c(new aec(this.h.k.b, 29));
      } else {
         try {
            URL url = new URL(
               "http://session.minecraft.net/game/joinserver.jsp?user=" + this.h.k.b + "&sessionId=" + this.h.k.c + "&serverId=" + par1Packet2Handshake.a
            );
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(url.openStream()));
            String s1 = bufferedreader.readLine();
            bufferedreader.close();
            if (s1.equalsIgnoreCase("ok")) {
               this.c(new aec(this.h.k.b, 29));
            } else {
               this.g.a("disconnect.loginFailedInfo", new Object[]{s1});
            }
         } catch (Exception exception) {
            exception.printStackTrace();
            this.g.a("disconnect.genericReason", new Object[]{"Internal client error: " + exception.toString()});
         }
      }
   }

   public void c() {
      this.f = true;
      this.g.a();
      this.g.a("disconnect.closed", new Object[0]);
   }

   public void a(Packet24MobSpawn par1Packet24MobSpawn) {
      double d = par1Packet24MobSpawn.c / 32.0;
      double d1 = par1Packet24MobSpawn.d / 32.0;
      double d2 = par1Packet24MobSpawn.e / 32.0;
      float f = par1Packet24MobSpawn.f * 360 / 256.0F;
      float f1 = par1Packet24MobSpawn.g * 360 / 256.0F;
      EntityLiving entityliving = (EntityLiving)EntityList.a(par1Packet24MobSpawn.b, this.h.f);
      entityliving.ah = par1Packet24MobSpawn.c;
      entityliving.ai = par1Packet24MobSpawn.d;
      entityliving.aj = par1Packet24MobSpawn.e;
      entityliving.WorldGenSwamp = par1Packet24MobSpawn.h * 360 / 256.0F;
      Entity[] aentity = entityliving.Z();
      if (aentity != null) {
         int i = par1Packet24MobSpawn.a - entityliving.f;

         for (int j = 0; j < aentity.length; j++) {
            aentity[j].f += i;
         }
      }

      entityliving.f = par1Packet24MobSpawn.a;
      entityliving.b(d, d1, d2, f, f1);
      this.i.a(par1Packet24MobSpawn.a, entityliving);
      List list = par1Packet24MobSpawn.b();
      if (list != null) {
         entityliving.y().a(list);
      }
   }

   public void a(zf par1Packet4UpdateTime) {
      this.h.f.a(par1Packet4UpdateTime.a);
   }

   public void a(Packet6SpawnPosition par1Packet6SpawnPosition) {
      this.h.h.a(new ChunkCoordinates(par1Packet6SpawnPosition.a, par1Packet6SpawnPosition.b, par1Packet6SpawnPosition.c));
      this.h.f.B().setSpawnPosition(par1Packet6SpawnPosition.a, par1Packet6SpawnPosition.b, par1Packet6SpawnPosition.c);
   }

   public void a(adv par1Packet39AttachEntity) {
      Object obj = this.a(par1Packet39AttachEntity.a);
      Entity entity = this.a(par1Packet39AttachEntity.b);
      if (par1Packet39AttachEntity.a == this.h.h.f) {
         obj = this.h.h;
      }

      if (obj != null) {
         ((Entity)obj).h(entity);
      }
   }

   public void a(gt par1Packet38EntityStatus) {
      Entity entity = this.a(par1Packet38EntityStatus.a);
      if (entity != null) {
         entity.a(par1Packet38EntityStatus.b);
      }
   }

   private Entity a(int par1) {
      return par1 == this.h.h.f ? this.h.h : this.i.a(par1);
   }

   public void a(ds par1Packet8UpdateHealth) {
      this.h.h.d(par1Packet8UpdateHealth.a);
      this.h.h.aF().a(par1Packet8UpdateHealth.b);
      this.h.h.aF().b(par1Packet8UpdateHealth.c);
   }

   public void a(ih par1Packet43Experience) {
      this.h.h.a(par1Packet43Experience.a, par1Packet43Experience.b, par1Packet43Experience.c);
   }

   public void a(kx par1Packet9Respawn) {
      if (par1Packet9Respawn.a != this.h.h.aB) {
         this.j = false;
         this.i = new WorldClient(this, new fj(0L, par1Packet9Respawn.d, false, false, par1Packet9Respawn.e), par1Packet9Respawn.a, par1Packet9Respawn.b);
         this.i.F = true;
         this.h.a(this.i);
         this.h.h.aB = par1Packet9Respawn.a;
         this.h.a(new ez(this));
      }

      this.h.a(true, par1Packet9Respawn.a, false);
      ((PlayerControllerMP)this.h.c).a(par1Packet9Respawn.d == 1);
   }

   public void a(Packet60Explosion par1Packet60Explosion) {
      Explosion explosion = new Explosion(this.h.f, null, par1Packet60Explosion.a, par1Packet60Explosion.b, par1Packet60Explosion.c, par1Packet60Explosion.d);
      explosion.g = par1Packet60Explosion.e;
      explosion.a(true);
   }

   public void a(gr par1Packet100OpenWindow) {
      EntityPlayerSP entityplayersp = this.h.h;
      switch (par1Packet100OpenWindow.b) {
         case 0:
            entityplayersp.a(new me(par1Packet100OpenWindow.c, par1Packet100OpenWindow.d));
            entityplayersp.ar.f = par1Packet100OpenWindow.a;
            break;
         case 1:
            entityplayersp.displayWorkbenchGUI(MathHelper.d(entityplayersp.o), MathHelper.c(entityplayersp.p), MathHelper.d(entityplayersp.q));
            entityplayersp.ar.f = par1Packet100OpenWindow.a;
            break;
         case 2:
            entityplayersp.a(new TileEntityFurnace());
            entityplayersp.ar.f = par1Packet100OpenWindow.a;
            break;
         case 3:
            entityplayersp.a(new TileEntityDispenser());
            entityplayersp.ar.f = par1Packet100OpenWindow.a;
            break;
         case 4:
            entityplayersp.displayGUIEnchantment(MathHelper.d(entityplayersp.o), MathHelper.c(entityplayersp.p), MathHelper.d(entityplayersp.q));
            entityplayersp.ar.f = par1Packet100OpenWindow.a;
            break;
         case 5:
            entityplayersp.a(new TileEntityBrewingStand());
            entityplayersp.ar.f = par1Packet100OpenWindow.a;
      }
   }

   public void a(fu par1Packet103SetSlot) {
      EntityPlayerSP entityplayersp = this.h.h;
      if (par1Packet103SetSlot.a == -1) {
         entityplayersp.ap.b(par1Packet103SetSlot.c);
      } else if (par1Packet103SetSlot.a == 0 && par1Packet103SetSlot.b >= 36 && par1Packet103SetSlot.b < 45) {
         ItemStack itemstack = entityplayersp.aq.b(par1Packet103SetSlot.b).b();
         if (par1Packet103SetSlot.c != null && (itemstack == null || itemstack.a < par1Packet103SetSlot.c.a)) {
            par1Packet103SetSlot.c.b = 5;
         }

         entityplayersp.aq.a(par1Packet103SetSlot.b, par1Packet103SetSlot.c);
      } else if (par1Packet103SetSlot.a == entityplayersp.ar.f) {
         entityplayersp.ar.a(par1Packet103SetSlot.b, par1Packet103SetSlot.c);
      }
   }

   public void a(kn par1Packet106Transaction) {
      dd container = null;
      EntityPlayerSP entityplayersp = this.h.h;
      if (par1Packet106Transaction.a == 0) {
         container = entityplayersp.aq;
      } else if (par1Packet106Transaction.a == entityplayersp.ar.f) {
         container = entityplayersp.ar;
      }

      if (container != null) {
         if (par1Packet106Transaction.c) {
            container.a(par1Packet106Transaction.b);
         } else {
            container.b(par1Packet106Transaction.b);
            this.c(new kn(par1Packet106Transaction.a, par1Packet106Transaction.b, true));
         }
      }
   }

   public void a(abl par1Packet104WindowItems) {
      EntityPlayerSP entityplayersp = this.h.h;
      if (par1Packet104WindowItems.a == 0) {
         entityplayersp.aq.a(par1Packet104WindowItems.b);
      } else if (par1Packet104WindowItems.a == entityplayersp.ar.f) {
         entityplayersp.ar.a(par1Packet104WindowItems.b);
      }
   }

   public void a(Packet130UpdateSign par1Packet130UpdateSign) {
      if (this.h.f.blockExists(par1Packet130UpdateSign.a, par1Packet130UpdateSign.b, par1Packet130UpdateSign.c)) {
         TileEntity tileentity = this.h.f.getBlockTileEntity(par1Packet130UpdateSign.a, par1Packet130UpdateSign.b, par1Packet130UpdateSign.c);
         if (tileentity instanceof sc) {
            sc tileentitysign = (sc)tileentity;
            if (tileentitysign.a()) {
               for (int i = 0; i < 4; i++) {
                  tileentitysign.a[i] = par1Packet130UpdateSign.d[i];
               }

               tileentitysign.j();
            }
         }
      }
   }

   public void a(Packet132TileEntityData par1Packet132TileEntityData) {
      if (this.h.f.blockExists(par1Packet132TileEntityData.a, par1Packet132TileEntityData.b, par1Packet132TileEntityData.c)) {
         TileEntity tileentity = this.h.f.getBlockTileEntity(par1Packet132TileEntityData.a, par1Packet132TileEntityData.b, par1Packet132TileEntityData.c);
         if (tileentity != null && par1Packet132TileEntityData.d == 1 && tileentity instanceof TileEntityMobSpawner) {
            ((TileEntityMobSpawner)tileentity).a(EntityList.a(par1Packet132TileEntityData.e));
         }
      }
   }

   public void a(jl par1Packet105UpdateProgressbar) {
      EntityPlayerSP entityplayersp = this.h.h;
      this.a(par1Packet105UpdateProgressbar);
      if (entityplayersp.ar != null && entityplayersp.ar.f == par1Packet105UpdateProgressbar.a) {
         entityplayersp.ar.a(par1Packet105UpdateProgressbar.b, par1Packet105UpdateProgressbar.c);
      }
   }

   public void a(ta par1Packet5PlayerInventory) {
      Entity entity = this.a(par1Packet5PlayerInventory.a);
      if (entity != null) {
         entity.b(par1Packet5PlayerInventory.b, par1Packet5PlayerInventory.c, par1Packet5PlayerInventory.d);
      }
   }

   public void a(add par1Packet101CloseWindow) {
      this.h.h.TileEntityMobSpawnerRenderer();
   }

   public void a(Packet54PlayNoteBlock par1Packet54PlayNoteBlock) {
      this.h
         .f
         .playNoteAt(
            par1Packet54PlayNoteBlock.a, par1Packet54PlayNoteBlock.b, par1Packet54PlayNoteBlock.c, par1Packet54PlayNoteBlock.d, par1Packet54PlayNoteBlock.e
         );
   }

   public void a(us par1Packet70Bed) {
      EntityPlayerSP entityplayersp = this.h.h;
      int i = par1Packet70Bed.b;
      if (i >= 0 && i < us.a.length && us.a[i] != null) {
         entityplayersp.b(us.a[i]);
      }

      if (i == 1) {
         this.i.B().b(true);
         this.i.k(1.0F);
      } else if (i == 2) {
         this.i.B().b(false);
         this.i.k(0.0F);
      } else if (i == 3) {
         ((PlayerControllerMP)this.h.c).a(par1Packet70Bed.c == 1);
      } else if (i == 4) {
         this.h.a(new c());
      }
   }

   public void a(ai par1Packet131MapData) {
      if (par1Packet131MapData.a == Item.bd.bQ) {
         ItemMap.a(par1Packet131MapData.b, this.h.f).a(par1Packet131MapData.c);
      } else {
         System.out.println("Unknown itemid: " + par1Packet131MapData.b);
      }
   }

   public void a(Packet61DoorChange par1Packet61DoorChange) {
      this.h.f.playAuxSFX(par1Packet61DoorChange.a, par1Packet61DoorChange.c, par1Packet61DoorChange.d, par1Packet61DoorChange.e, par1Packet61DoorChange.b);
   }

   public void a(kk par1Packet200Statistic) {
      ((EntityClientPlayerMP)this.h.h).b(gv.a(par1Packet200Statistic.a), par1Packet200Statistic.b);
   }

   public void a(wb par1Packet41EntityEffect) {
      Entity entity = this.a(par1Packet41EntityEffect.a);
      if (entity != null && entity instanceof EntityLiving) {
         ((EntityLiving)entity).b(new alg(par1Packet41EntityEffect.b, par1Packet41EntityEffect.d, par1Packet41EntityEffect.c));
      }
   }

   public void a(ado par1Packet42RemoveEntityEffect) {
      Entity entity = this.a(par1Packet42RemoveEntityEffect.a);
      if (entity != null && entity instanceof EntityLiving) {
         ((EntityLiving)entity).m(par1Packet42RemoveEntityEffect.b);
      }
   }

   public boolean a() {
      return false;
   }

   public void a(wj par1Packet201PlayerInfo) {
      ah guiplayerinfo = (ah)this.k.get(par1Packet201PlayerInfo.a);
      if (guiplayerinfo == null && par1Packet201PlayerInfo.b) {
         guiplayerinfo = new ah(par1Packet201PlayerInfo.a);
         this.k.put(par1Packet201PlayerInfo.a, guiplayerinfo);
         this.c.add(guiplayerinfo);
      }

      if (guiplayerinfo != null && !par1Packet201PlayerInfo.b) {
         this.k.remove(par1Packet201PlayerInfo.a);
         this.c.remove(guiplayerinfo);
      }

      if (par1Packet201PlayerInfo.b && guiplayerinfo != null) {
         guiplayerinfo.b = par1Packet201PlayerInfo.c;
      }
   }

   public void a(acw par1Packet0KeepAlive) {
      this.c(new acw(par1Packet0KeepAlive.a));
   }

   public void a(ym par1Packet202PlayerAbilities) {
      EntityPlayerSP entityplayersp = this.h.h;
      entityplayersp.aT.b = par1Packet202PlayerAbilities.b;
      entityplayersp.aT.d = par1Packet202PlayerAbilities.d;
      entityplayersp.aT.a = par1Packet202PlayerAbilities.a;
      entityplayersp.aT.c = par1Packet202PlayerAbilities.c;
   }
}
