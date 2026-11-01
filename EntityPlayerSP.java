import net.minecraft.client.Minecraft;

public class EntityPlayerSP extends EntityPlayer {
   public oy a;
   protected Minecraft b;
   protected int c = 0;
   public int d = 0;
   public float e;
   public float NoiseGeneratorPerlin;
   public float MapGenVillage;
   public float GenLayerHills;
   private ch cl = new ch();
   private ch cm = new ch();
   private ch cn = new ch();

   public EntityPlayerSP(Minecraft par1Minecraft, World par2World, fc par3Session, int par4) {
      super(par2World);
      this.b = par1Minecraft;
      this.aB = par4;
      if (par3Session != null && par3Session.b != null && par3Session.b.length() > 0) {
         this.Z = "http://s3.amazonaws.com/MinecraftSkins/" + par3Session.b + ".png";
      }

      this.aA = par3Session.b;
   }

   @Override
   public void b(double par1, double par3, double par5) {
      super.b(par1, par3, par5);
   }

   public void teleportPlayer(String tpXPos, String tpYPos, String tpZPos) {
      double testPos = 0.0;
      double newPosX;
      if (tpXPos.charAt(0) == '~') {
         if (tpXPos.substring(1).equals("")) {
            newPosX = this.o;
         } else {
            try {
               testPos = Double.parseDouble(tpXPos.substring(1));
            } catch (NumberFormatException ex) {
               testPos = 0.0;
            }

            if (Double.isNaN(testPos) || Double.isInfinite(testPos)) {
               testPos = 0.0;
            }

            newPosX = this.o + testPos;
         }
      } else if (tpXPos.charAt(0) == '#') {
         if (tpXPos.substring(1).equals("")) {
            newPosX = this.o;
         } else {
            try {
               testPos = Double.parseDouble(tpXPos.substring(1));
            } catch (NumberFormatException ex) {
               testPos = 0.0;
            }

            if (Double.isNaN(testPos) || Double.isInfinite(testPos)) {
               testPos = 0.0;
            }

            newPosX = this.o * testPos;
         }
      } else {
         try {
            testPos = Double.parseDouble(tpXPos);
         } catch (NumberFormatException ex) {
            testPos = this.o;
         }

         if (Double.isNaN(testPos) || Double.isInfinite(testPos)) {
            testPos = this.o;
         }

         newPosX = testPos;
      }

      testPos = 0.0;
      double newPosY;
      if (tpYPos.charAt(0) == '~') {
         if (tpYPos.substring(1).equals("")) {
            newPosY = this.p;
         } else {
            try {
               testPos = Double.parseDouble(tpYPos.substring(1));
            } catch (NumberFormatException ex) {
               testPos = 1.0;
            }

            if (Double.isNaN(testPos) || Double.isInfinite(testPos)) {
               testPos = 1.0;
            }

            newPosY = this.p + testPos;
         }
      } else if (tpYPos.charAt(0) == '#') {
         if (tpYPos.substring(1).equals("")) {
            newPosY = this.p;
         } else {
            try {
               testPos = Double.parseDouble(tpYPos.substring(1));
            } catch (NumberFormatException ex) {
               testPos = 1.0;
            }

            if (Double.isNaN(testPos) || Double.isInfinite(testPos)) {
               testPos = 1.0;
            }

            newPosY = this.p * testPos;
         }
      } else {
         try {
            testPos = Double.parseDouble(tpYPos);
         } catch (NumberFormatException ex) {
            testPos = this.p;
         }

         if (Double.isNaN(testPos) || Double.isInfinite(testPos)) {
            testPos = this.p;
         }

         newPosY = testPos;
      }

      testPos = 0.0;
      double newPosZ;
      if (tpZPos.charAt(0) == '~') {
         if (tpZPos.substring(1).equals("")) {
            newPosZ = this.q;
         } else {
            try {
               testPos = Double.parseDouble(tpZPos.substring(1));
            } catch (NumberFormatException ex) {
               testPos = 0.0;
            }

            if (Double.isNaN(testPos) || Double.isInfinite(testPos)) {
               testPos = 0.0;
            }

            newPosZ = this.q + testPos;
         }
      } else if (tpZPos.charAt(0) == '#') {
         if (tpZPos.substring(1).equals("")) {
            newPosZ = this.q;
         } else {
            try {
               testPos = Double.parseDouble(tpZPos.substring(1));
            } catch (NumberFormatException ex) {
               testPos = 1.0;
            }

            if (Double.isNaN(testPos) || Double.isInfinite(testPos)) {
               testPos = 1.0;
            }

            newPosZ = this.q * testPos;
         }
      } else {
         try {
            testPos = Double.parseDouble(tpZPos);
         } catch (NumberFormatException ex) {
            testPos = this.q;
         }

         if (Double.isNaN(testPos) || Double.isInfinite(testPos)) {
            testPos = this.q;
         }

         newPosZ = testPos;
      }

      this.b(newPosX, newPosY, newPosZ, this.u, this.v);
      this.b.f.a(this, false);
   }

   public void setPlayerFlySpeed(int speedSetting) {
      if (speedSetting <= 0) {
         speedSetting = 1;
      } else if (speedSetting > 5) {
         speedSetting = 5;
      }

      this.flySpeed = speedSetting;
   }

   @Override
   public void y_() {
      super.y_();
      this.ce = this.a.a;
      this.cf = this.a.b;
      this.ch = this.a.d;
      this.MapGenVillage = this.e;
      this.GenLayerHills = this.NoiseGeneratorPerlin;
      this.NoiseGeneratorPerlin = (float)(this.NoiseGeneratorPerlin + (this.v - this.NoiseGeneratorPerlin) * 0.5);
      this.e = (float)(this.e + (this.u - this.e) * 0.5);
   }

   @Override
   protected boolean H_() {
      return true;
   }

   @Override
   public void e() {
      if (this.d > 0) {
         this.d--;
         if (this.d == 0) {
            this.d(false);
         }
      }

      if (this.c > 0) {
         this.c--;
      }

      if (this.b.c.e()) {
         this.o = this.q = 0.5;
         this.o = 0.0;
         this.q = 0.0;
         this.u = this.V / 12.0F;
         this.v = 10.0F;
         this.p = 68.5;
      } else {
         if (!this.b.K.a(dp.f)) {
            this.b.v.b(dp.f);
         }

         this.aS = this.aR;
         if (this.aQ) {
            if (!this.k.F && this.j != null) {
               this.h(null);
            }

            if (this.b.s != null) {
               this.b.a((vp)null);
            }

            if (this.aR == 0.0F) {
               this.b.C.a("portal.trigger", 1.0F, this.U.nextFloat() * 0.4F + 0.8F);
            }

            this.aR += 0.0125F;
            if (this.aR >= 1.0F) {
               this.aR = 1.0F;
               if (!this.k.F) {
                  this.aP = 10;
                  this.b.C.a("portal.travel", 1.0F, this.U.nextFloat() * 0.4F + 0.8F);
                  byte byte0 = 0;
                  if (this.aB == -1) {
                     byte0 = 0;
                  } else {
                     byte0 = -1;
                  }

                  this.b.a(byte0);
                  this.a(dp.x);
               }
            }

            this.aQ = false;
         } else if (this.a(aad.k) && this.b(aad.k).b() > 60) {
            this.aR += 0.006666667F;
            if (this.aR > 1.0F) {
               this.aR = 1.0F;
            }
         } else {
            if (this.aR > 0.0F) {
               this.aR -= 0.05F;
            }

            if (this.aR < 0.0F) {
               this.aR = 0.0F;
            }
         }

         if (this.aP > 0) {
            this.aP--;
         }

         boolean flag = this.a.d;
         float f = 0.8F;
         boolean flag1 = this.a.b >= f;
         this.a.a();
         if (this.aj()) {
            this.a.a *= 0.2F;
            this.a.b *= 0.2F;
            this.c = 0;
         }

         if (this.a.e && this.Q < 0.2F) {
            this.Q = 0.2F;
         }

         this.h(this.o - this.I * 0.35, this.y.b + 0.5, this.q + this.I * 0.35);
         this.h(this.o - this.I * 0.35, this.y.b + 0.5, this.q - this.I * 0.35);
         this.h(this.o + this.I * 0.35, this.y.b + 0.5, this.q - this.I * 0.35);
         this.h(this.o + this.I * 0.35, this.y.b + 0.5, this.q + this.I * 0.35);
         boolean flag2 = this.aF().a() > 6.0F;
         if (this.z && !flag1 && this.a.b >= f && !this.W() && flag2 && !this.aj() && !this.a(aad.q)) {
            if (this.c == 0) {
               this.c = 7;
            } else {
               this.d(true);
               this.c = 0;
            }
         }

         if (this.V()) {
            this.c = 0;
         }

         if (this.W() && (this.a.b < f || this.A || !flag2)) {
            this.d(false);
         }

         if (this.aT.c && !flag && this.a.d) {
            if (this.at == 0) {
               this.at = 7;
            } else {
               this.aT.b = !this.aT.b;
               this.aI();
               this.at = 0;
            }
         }

         if (this.aT.b) {
            if (this.a.e) {
               this.s -= 0.15;
            }

            if (this.a.d) {
               this.s += 0.15;
            }
         }

         super.e();
         if (this.z && this.aT.b) {
            this.aT.b = false;
            this.aI();
         }
      }
   }

   @Override
   public void c(int par1) {
      if (!this.k.F) {
         if (this.aB == 1 && par1 == 1) {
            this.a(dp.C);
            this.b.a(new c());
         } else {
            this.a(dp.B);
            this.b.C.a("portal.travel", 1.0F, this.U.nextFloat() * 0.4F + 0.8F);
            this.b.a(1);
         }
      }
   }

   public float I_() {
      float f = 1.0F;
      if (this.aT.b) {
         f *= 1.1F;
      }

      f *= (this.EntityFireball * this.at() / this.aX + 1.0F) / 2.0F;
      if (this.aj() && this.ah().c == Item.k.bQ) {
         int i = this.BlockPortal();
         float f1 = i / 20.0F;
         if (f1 > 1.0F) {
            f1 = 1.0F;
         } else {
            f1 *= f1;
         }

         f *= 1.0F - f1 * 0.15F;
      }

      return f;
   }

   @Override
   public void b(ady par1NBTTagCompound) {
      super.b(par1NBTTagCompound);
      par1NBTTagCompound.a("Score", this.EntityThrowable);
   }

   @Override
   public void a(ady par1NBTTagCompound) {
      super.a(par1NBTTagCompound);
      this.EntityThrowable = par1NBTTagCompound.f("Score");
   }

   @Override
   public void TileEntityMobSpawnerRenderer() {
      super.TileEntityMobSpawnerRenderer();
      this.b.a((vp)null);
   }

   @Override
   public void a(sc par1TileEntitySign) {
      this.b.a(new GuiEditSign(par1TileEntitySign));
   }

   @Override
   public void a(io par1IInventory) {
      this.b.a(new zn(this.ap, par1IInventory));
   }

   @Override
   public void displayWorkbenchGUI(long par1, int par2, long par3) {
      this.b.a(new GuiCrafting(this.ap, this.k, par1, par2, par3));
   }

   @Override
   public void displayGUIEnchantment(long par1, int par2, long par3) {
      this.b.a(new GuiEnchantment(this.ap, this.k, par1, par2, par3));
   }

   @Override
   public void a(TileEntityFurnace par1TileEntityFurnace) {
      this.b.a(new kv(this.ap, par1TileEntityFurnace));
   }

   @Override
   public void a(TileEntityBrewingStand par1TileEntityBrewingStand) {
      this.b.a(new hg(this.ap, par1TileEntityBrewingStand));
   }

   @Override
   public void a(TileEntityDispenser par1TileEntityDispenser) {
      this.b.a(new fb(this.ap, par1TileEntityDispenser));
   }

   @Override
   public void d(Entity par1Entity) {
      this.b.j.a(new EntityCrit2FX(this.b.f, par1Entity));
   }

   @Override
   public void i(Entity par1Entity) {
      EntityCrit2FX entitycrit2fx = new EntityCrit2FX(this.b.f, par1Entity, "magicCrit");
      this.b.j.a(entitycrit2fx);
   }

   @Override
   public void b(Entity par1Entity, int par2) {
      this.b.j.a(new EntityPickupFX(this.b.f, par1Entity, this, -0.5F));
   }

   public void a(String s) {
      this.b.w.a(s);
   }

   @Override
   public boolean V() {
      return this.a.e && !this.aK;
   }

   @Override
   public void d(int par1) {
      int i = this.ItemBucket() - par1;
      if (i <= 0) {
         this.l(par1);
         if (i < 0) {
            this.Y = this.ba / 2;
         }
      } else {
         this.cc = i;
         this.l(this.ItemBucket());
         this.Y = this.ba;
         this.c(md.k, i);
         this.bA = this.bB = 10;
      }
   }

   @Override
   public void ag() {
      this.b.a(false, 0, false);
   }

   @Override
   public void ab() {
   }

   @Override
   public void b(String par1Str) {
      this.b.w.c(par1Str);
   }

   @Override
   public void a(ajw par1StatBase, int par2) {
      if (par1StatBase != null) {
         if (par1StatBase.e()) {
            aeb achievement = (aeb)par1StatBase;
            if (achievement.c == null || this.b.K.a(achievement.c)) {
               if (!this.b.K.a(achievement)) {
                  this.b.v.a(achievement);
               }

               this.b.K.a(par1StatBase, par2);
            }
         } else {
            this.b.K.a(par1StatBase, par2);
         }
      }
   }

   private boolean isBlockTranslucent(long par1, int par2, long par3) {
      return this.k.isBlockNormalCube(par1, par2, par3);
   }

   @Override
   protected boolean h(double par1, double par3, double par5) {
      long i = MathHelper.d(par1);
      int j = MathHelper.c(par3);
      long k = MathHelper.d(par5);
      double d = par1 - i;
      double d1 = par5 - k;
      if (this.isBlockTranslucent(i, j, k) || this.isBlockTranslucent(i, j + 1, k)) {
         boolean flag = !this.isBlockTranslucent(i - 1L, j, k) && !this.isBlockTranslucent(i - 1L, j + 1, k);
         boolean flag1 = !this.isBlockTranslucent(i + 1L, j, k) && !this.isBlockTranslucent(i + 1L, j + 1, k);
         boolean flag2 = !this.isBlockTranslucent(i, j, k - 1L) && !this.isBlockTranslucent(i, j + 1, k - 1L);
         boolean flag3 = !this.isBlockTranslucent(i, j, k + 1L) && !this.isBlockTranslucent(i, j + 1, k + 1L);
         byte byte0 = -1;
         double d2 = 9999.0;
         if (flag && d < d2) {
            d2 = d;
            byte0 = 0;
         }

         if (flag1 && 1.0 - d < d2) {
            d2 = 1.0 - d;
            byte0 = 1;
         }

         if (flag2 && d1 < d2) {
            d2 = d1;
            byte0 = 4;
         }

         if (flag3 && 1.0 - d1 < d2) {
            double d3 = 1.0 - d1;
            byte0 = 5;
         }

         float f = 0.1F;
         if (byte0 == 0) {
            this.r = -f;
         }

         if (byte0 == 1) {
            this.r = f;
         }

         if (byte0 == 4) {
            this.t = -f;
         }

         if (byte0 == 5) {
            this.t = f;
         }
      }

      return false;
   }

   @Override
   public void d(boolean par1) {
      super.d(par1);
      this.d = par1 ? 600 : 0;
   }

   public void a(float par1, int par2, int par3) {
      this.aW = par1;
      this.aV = par2;
      this.aU = par3;
   }
}
